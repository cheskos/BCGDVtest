package com.chisko.bcgdvtest.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.chisko.bcgdvtest.BCGDVTestApp
import com.chisko.bcgdvtest.R
import com.chisko.bcgdvtest.base.BaseActivity
import com.chisko.bcgdvtest.base.BasePresenter
import com.chisko.bcgdvtest.model.RestaurantModel
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.MainActivityView {

    @Inject lateinit var presenter: MainPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter? = presenter

    override fun setupComponent(appComponent: BCGDVTestAppComponent) {

    }

    override fun displayRestaurants(data: List<RestaurantModel>) {

    }

    override fun showMessage(message: String) {
        SnackBar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}