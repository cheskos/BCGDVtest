package com.chisko.bcgdvtest.model

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class CSVReader(private val inputStream: InputStream) {

    fun read(): List<String> {
        val result = ArrayList<String>()
        val reader = BufferedReader(InputStreamReader(inputStream))
        try {
            var csvLine = ""
            while(csvLine != null) {
                val line = csvLine.split(",").toString()
                result.add(line)
                csvLine = reader.readLine()
            }

        } catch (exception: IOException) {

        } finally {
            try {

            }
        }
    }
}