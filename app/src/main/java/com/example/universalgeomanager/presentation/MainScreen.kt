package com.example.universalgeomanager.presentation

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import com.example.universalgeomanager.R
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.MapEventsOverlay
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.compass.CompassOverlay
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(/*viewModel: ViewModel*/mapView: MapView) {
    val snackbarHostState = remember { SnackbarHostState() }

    BottomSheetScaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)},
        sheetContainerColor = Color.Gray,
        sheetContent = {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Получить последнюю локацию", fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Широта: ${43.0244167} Долгота: ${131.8931624}" , fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Остановить отслеживание локации", fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Широта: ${43.0244167} Долгота: ${131.8931624}" , fontSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Начать отслеживание геозон", fontSize = 15.sp)
            }
        }
    }) {
        MapSurface(mapView = mapView)
    }
}

@Composable
fun MapSurface(mapView: MapView){

    Surface(
        modifier= Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            MapView(mapView = mapView)
        }
    }
}

private fun MapView.onAnimateToNewPlace(point: GeoPoint) {

    //val point = GeoPoint(43.1199556,131.8959697)

    controller.animateTo(point, 15.0, 2000L)
    Log.d("FinalMapLearnLogs", "Going to: ${point.altitude}, ${point.longitude}")

}

@Composable
private fun MapView(mapView: MapView){

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        AndroidView(
            factory = {
                        mapView.apply {
                            setTileSource(TileSourceFactory.MAPNIK)
                            setMultiTouchControls(true)
                            setMapConfigurations()
                            onAnimateToNewPlace(GeoPoint(43.0244167,131.8931624))
                        }
                      },
            modifier = Modifier.fillMaxSize()
        )
    }

    LaunchedEffect(key1 = Unit, block = {
        mapView.apply {
            controller.zoomTo(10, 1000L)
            setMapConfigurations()
        }
    })
}

fun MapView.setMapConfigurations(){

    val dm : DisplayMetrics = context.resources.displayMetrics

    //Переворот карты
    val rotationalGuestOverlay = RotationGestureOverlay(this)
    setMultiTouchControls(true)
    overlays.add(rotationalGuestOverlay)

    //Компас
    val compassOverlay = CompassOverlay( context, this )
    compassOverlay.enableCompass()
    overlays.add(compassOverlay)

    this.addMarkerToMap(
        GeoPoint(43.0244167,131.8931624),
        "Me now",
        "Really me now",
        "me"
    )
}

fun MapView.addMarkerToMap(
    geoPoint:GeoPoint,
    markTitle:String,
    description:String,
    id:String
) {
    val marker = Marker(this)
    marker.apply{
        position = geoPoint
        icon = ResourcesCompat.getDrawable(resources, org.osmdroid.library.R.drawable.marker_default, null)
        title = markTitle
        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        this.subDescription = description
        this.id = id
    }

    overlays.add(marker)
    invalidate()

}