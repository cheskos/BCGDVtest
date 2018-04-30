package com.chisko.bcgdvtest.util

import com.chisko.bcgdvtest.model.RestaurantModel

class Utils {

    companion object {
        @JvmStatic fun parseSchedules(name: String, schedules: String): RestaurantModel {

            val datesArray = schedules.split(Regex("\\s/"))

            val schedulesArray = arrayListOf<String>()
            datesArray.forEach {
                val value = it.trim()
                schedulesArray.add(value)
            }

            val finalName = name.trim().removePrefix("[").removeSuffix("\"").removePrefix("\"")


            val finalDaysArray = arrayListOf<String>()
            var hours = ""
            schedulesArray.forEach {

                val tempDaysArray = arrayListOf<String>()

                if (it.contains(", ")) {
                    /*  The dates follow the patterns:
                            "Mon-Thu, Sun 11:30 am - 9:00 pm"
                            "Mon, Wed-Sun 11:00 am - 10:00 pm"           */

                    /*  Get the index of the comma  */
                    val scheduleDays = it.substring(0, 13)
                    val commaIndex = scheduleDays
                            .trim()
                            .indexOf(", ")
                    val secondSpaceIndex = it.indexOf(" ", it.indexOf(" ") + 1)

                    /*  Split to get the days  */
                    tempDaysArray.add(scheduleDays.substring(0, commaIndex).trim())

                    tempDaysArray.add(scheduleDays.substring(commaIndex + 1, secondSpaceIndex).trim())

                    /*  Split to get the hours   */
                    hours = it.substring(13, (it.lastIndex + 1))
                            .trim()
                            .removeSuffix("]")
                            .removeSuffix("\"")
                } else {
                    /*   The dates follow the patterns:
                            "Mon-Sun 11:30 am - 9:00 pm"
                            "Sun 11:00 am - 11:00 pm"            */
                    tempDaysArray.add(it.substring(0, it.indexOf(" "))
                            .trim())

                    hours = it.substring(it.indexOf(" "), (it.lastIndex + 1))
                            .trim()
                            .removeSuffix("]")
                            .removeSuffix("\"")
                }


                for (days: String in tempDaysArray) {
                    if (days.length == 3) {
                        finalDaysArray.add("${days.substring(0, 3)} $hours")
                    } else {
                        finalDaysArray.add("${days.substring(0, 3)} $hours")
                        finalDaysArray.add("${days.substring(4, 7)} $hours")
                    }
                }
            }

            var finalSchedule = ""

            for (item: String in finalDaysArray) {
                finalSchedule = finalSchedule.plus("$item\n")
            }

            return RestaurantModel(finalName, finalSchedule)
        }
    }
}