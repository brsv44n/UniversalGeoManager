package com.example.universalgeomanager.universalLocation.settingsClient

interface Status {
    var SUCCESS: Status
    var FAILURE: Status
    var MessageNotFound: Status
    var CoreException: Status

    //+методы
}