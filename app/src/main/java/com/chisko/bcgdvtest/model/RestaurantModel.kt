package com.chisko.bcgdvtest.model


data class RestaurantModel(
        val name: String,
        var days: arrayListOf<>,
        var hours: String
) {
}

enum class WeekDay(name: String) {
    MONDAY("MON"),
    TUESDAY("TUE0"),
    WEDNESDAY("WED"),
    THURSDAY("THU"),
    FRIDAY("FRI"),
    SATURDAY("SAT"),
    SUNDAY("SUN");

    override fun toString(): String {
        return name
    }
}