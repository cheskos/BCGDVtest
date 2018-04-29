package com.chisko.bcgdvtest.ui.main

import com.chisko.bcgdvtest.base.BaseCallback
import org.jetbrains.annotations.NotNull

interface MainDataSource {

    fun loadData(@NotNull callback: MainCallback)

    interface MainCallback: BaseCallback {
        fun dataLoaded(result: Map<String, String>)
    }
}