package com.chisko.bcgdvtest.model


data class RestaurantModel (
        var name: String,
        val schedule: String
): Comparable<WeekDay> {

    override fun compareTo(other: WeekDay): Int {
        return compareValuesBy(this, other.value , { it })
    }
}

