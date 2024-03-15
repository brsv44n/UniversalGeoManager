package com.example.unilocation.universalLocation.settingsClient

//TODO Rebuild this in Class with several constructors
interface Status {
    var SUCCESS: Status
    var FAILURE: Status
    var MessageNotFound: Status
    var CoreException: Status

    //+методы
}