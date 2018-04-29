package com.chisko.bcgdvtest.ui.main

import com.chisko.bcgdvtest.base.BasePresenter

class MainPresenter(val view: MainContract.MainActivityView,
                    private val dataSource: MainDataSource): BasePresenter(),
        MainContract.MainActivityPresenter, MainDataSource.MainCallback {

    var enabled = false

    override fun onStart() {
        enabled = true
    }

    override fun onStop() {
        enabled = false
    }

    override fun loadData() {
        if (enabled) {
            dataSource.loadData(this)
        }
    }

    override fun dataLoaded(result: Map<String, String>) {

        val value = result
//        view.displayRestaurants(result)
    }

    override fun error(cause: Exception) {
        view.showMessage(cause.localizedMessage)
    }
}