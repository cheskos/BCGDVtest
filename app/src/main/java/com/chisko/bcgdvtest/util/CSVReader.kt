package com.chisko.bcgdvtest.util

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class CSVReader(private val inputStream: InputStream) {

    fun read(): List<String> {
        val result = ArrayList<String>()
        val reader = BufferedReader(InputStreamReader(inputStream))
        try {
            var csvLine = reader.readLine()
            do {
                val line = csvLine.split("\\n").toString()
                if(!line.isBlank()) {
                    result.add(line)
                }
                csvLine = reader.readLine() ?: ""
            } while(csvLine != "")

        } catch (exception: IOException) {
            throw IOException("Error in reading CSV file: $exception")
        } finally {
            try {
                inputStream.close()
            } catch (exceptionClose: IOException) {
                throw RuntimeException("Error while closing CSV: $exceptionClose")
            }
        }
        return result
    }

}