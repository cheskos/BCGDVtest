package com.chisko.bcgdvtest.ui.main

import com.chisko.bcgdvtest.base.BasePresenter
import com.chisko.bcgdvtest.base.BaseView
import com.chisko.bcgdvtest.model.RestaurantModel

interface MainContract {

    interface MainActivityView: BaseView {
        fun displayRestaurants(data: List<RestaurantModel>)
    }

    interface MainActivityPresenter {
        fun loadData()
    }
}