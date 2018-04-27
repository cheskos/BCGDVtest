package com.chisko.bcgdvtest.ui.main

import com.chisko.bcgdvtest.base.BasePresenter

class MainPresenter(val view: MainContract.MainActivityView): BasePresenter(),
        MainContract.MainActivityPresenter {

    var enabled = false

    override fun onStart() {
        enabled = true
    }

    override fun onStop() {
        enabled = false
    }

    override fun loadData() {
        if (enabled) {

        }
    }
}