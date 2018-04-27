package com.chisko.bcgdvtest

import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.design.widget.Snackbar

fun AppCompatActivity.showSnackbar(coordinator: CoordinatorLayout, message: String) {
    Snackbar.make(coordinator, message, Snackbar.LENGTH_LONG)
            .show()
}