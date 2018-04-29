package com.chisko.bcgdvtest.ui.main

import android.content.Context
import com.chisko.bcgdvtest.R
import com.chisko.bcgdvtest.model.CSVReader
import org.jetbrains.annotations.NotNull
import javax.inject.Inject


class MainDataRepository @Inject constructor(
        private val context: Context
): MainDataSource {

    override fun loadData(@NotNull callback: MainDataSource.MainCallback) {
        val inputStream = context.resources.openRawResource(R.raw.rest_hours)
        val csvFile = CSVReader(inputStream)
        val scoreList = csvFile.read()

        // Map the list of strings read by the CSV with the restaurant name as key and all the
        // schedules as value
        val resultMap: Map<String, String> = scoreList.map {
            it.split(",")[0] to it.split("\",\"")[1]
        }.toMap()

        callback.dataLoaded(resultMap)
    }
}