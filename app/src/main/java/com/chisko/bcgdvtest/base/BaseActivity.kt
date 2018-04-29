package com.chisko.bcgdvtest.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.chisko.bcgdvtest.BCGDVTestAppComponent
import com.chisko.bcgdvtest.app

abstract class BaseActivity: AppCompatActivity() {

    abstract fun getLayout(): Int
    abstract fun getPresenter(): BasePresenter?
    abstract fun setupComponent(appComponent : BCGDVTestAppComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayout())

        ButterKnife.bind(this)

        setupComponent(app.component)
    }

    override fun onStart() {
        super.onStart()

        getPresenter()
                ?.onStart()
    }

    override fun onStop() {
        super.onStop()

        getPresenter()
                ?.onStop()
    }

}