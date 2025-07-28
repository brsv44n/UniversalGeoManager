# UniversalGeoManager

**UniversalGeoManager** — это Kotlin-библиотека, разработанная как учебный проект, предоставляющая единый интерфейс для работы с геолокацией и геозонами как на устройствах с **Google Play Services**, так и с **Huawei Mobile Services**.

Цель проекта — **снять необходимость дублирования кода** при работе с разными сервисами локации, позволяя разработчику использовать единую API-абстракцию.

---

## 📦 Особенности

- 🧩 Единый интерфейс `UniversalLocationClient` с реализациями под GMS и HMS
- 📍 Получение последнего местоположения и подписка на обновления
- 📐 Работа с геозонами (добавление, удаление, обработка событий)
- 🔧 Проверка и управление настройками локации
- 🗺️ Пример приложения с картой и работающей локацией

---

## 🧱 Основные интерфейсы

### 🔹 `LocationProviderClient`

Унифицированный API для работы с местоположением:
```kotlin
fun getLastLocation(): TaskWrapper<Location>
fun requestLocationUpdates(request: LocationRequest, locationCallback: LocationCallback, looper: Looper?): TaskWrapper<Any>
fun removeLocationUpdates(locationCallback: LocationCallback)
fun getLocationAvailability(): TaskWrapper<LocationAvailability>
fun flushLocations(): TaskWrapper<Any>
```

---

### 🔹 `GeofenceClient`

Интерфейс для работы с геозонами:
```kotlin
fun addGeofences(request: GeofenceRequest, pendingIntent: PendingIntent): TaskWrapper<Any>
fun removeGeofences(requestIds: List<String>): TaskWrapper<Any>
fun removeGeofences(pendingIntent: PendingIntent): TaskWrapper<Any>
```

---

### 🔹 `GeofenceBroadcastReceiver`

Базовый `BroadcastReceiver`, который обрабатывает события геозон как от Google, так и от Huawei:

```kotlin
abstract class GeofenceBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Обрабатывает события от GMS и HMS
    }

    abstract fun onEventReceived(event: UGeofenceEvent)
}
```

---

### 🔹 `SettingsClientInterface`

Интерфейс для проверки и управления настройками локации:
```kotlin
fun checkLocationSettings(locationSettingsRequest: LocationSettingsRequest): TaskWrapper<LocationSettingsResponse>
fun openLocationSettings()
```

---

## ⚠️ Статус проекта

🔧 В разработке (MVP-версия)  
✅ Основные интерфейсы реализованы  
🚫 Не ведётся активная разработка (проект заморожен)

---

## 📃 Лицензия

Этот проект распространяется под лицензией MIT. Подробнее см. в [LICENSE](./LICENSE).
