package com.chisko.bcgdvtest.ui.main

import com.chisko.bcgdvtest.base.BasePresenter
import com.chisko.bcgdvtest.model.RestaurantModel
import com.chisko.bcgdvtest.util.Utils
import timber.log.Timber

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

        val list = arrayListOf<RestaurantModel>()

        result.forEach { t, u ->
            val model = Utils.parseSchedules(t, u)
            list.add(model)
        }

        Timber.d("Size of list: ${list.size}")

        view.displayRestaurants(list)
    }

    override fun error(cause: Exception) {
        view.showMessage(cause.localizedMessage)
    }
}