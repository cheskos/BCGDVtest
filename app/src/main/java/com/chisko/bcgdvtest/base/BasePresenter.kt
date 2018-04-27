package com.chisko.bcgdvtest.base

/**
 * Base class for Presenters that allows an automatic activity lifecycle hooking in [BaseActivity]
 */
abstract class BasePresenter {
    abstract fun onStart()
    abstract fun onStop()
}