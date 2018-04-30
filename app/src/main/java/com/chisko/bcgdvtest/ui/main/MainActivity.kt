package com.chisko.bcgdvtest.ui.main

import android.content.Context
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import autodagger.AutoComponent
import autodagger.AutoExpose
import autodagger.AutoInjector
import butterknife.BindView
import com.chisko.bcgdvtest.*
import com.chisko.bcgdvtest.base.BaseActivity
import com.chisko.bcgdvtest.base.BasePresenter
import com.chisko.bcgdvtest.model.RestaurantModel
import com.chisko.bcgdvtest.util.RecyclerDivider
import dagger.Provides
import javax.inject.Inject

@AutoComponent(dependencies = [BCGDVTestApp::class],
        modules = [MainActivity.Module::class])
@AutoInjector
@ActivityScope
class MainActivity : BaseActivity(), MainContract.MainActivityView {

    @Inject lateinit var presenter: MainPresenter
    private lateinit var component: MainActivityComponent

    @BindView(R.id.restaurant_list) internal lateinit var recyclerView: RecyclerView

    private lateinit var restaurants: List<RestaurantModel>

    override fun getLayout(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter? = presenter

    override fun setupComponent(appComponent: BCGDVTestAppComponent) {
        component = DaggerMainActivityComponent.builder()
                .bCGDVTestAppComponent(appComponent)
                .module(Module(this))
                .build()
        component.inject(this)
    }

    override fun showMessage(message: String) {
        val coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinator)
        if(coordinatorLayout != null) {
            showSnackbar(coordinatorLayout, message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restaurants = arrayListOf()

        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = RestaurantRecyclerAdapter(arrayListOf())
        }
        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.item_separator)
        recyclerView.addItemDecoration(RecyclerDivider(dividerDrawable!!))
    }

    override fun onStart() {
        super.onStart()

        if(restaurants.isEmpty()) {
            presenter.loadData()
        }
    }

    override fun displayRestaurants(data: List<RestaurantModel>) {
        (recyclerView.adapter as RestaurantRecyclerAdapter).updateItems(data)
    }

    @dagger.Module
    inner class Module(private val view: MainContract.MainActivityView) {

        @Provides @AutoExpose(MainActivity::class)
        fun view() = view

        @Provides @AutoExpose(MainActivity::class)
        fun presenter(dataSource: MainDataSource): MainPresenter = MainPresenter(view, dataSource)

        @Provides @AutoExpose(MainActivity::class)
        fun dataSource(): MainDataSource = MainDataRepository(view as Context)
    }
}