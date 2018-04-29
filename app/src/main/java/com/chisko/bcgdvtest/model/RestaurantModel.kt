package com.chisko.bcgdvtest.model


data class RestaurantModel (
        val name: String,
        var schedule: String
) {
    init {
        val dates = schedule.split("/")
        for (value: String in dates) {

        }
    }
}

