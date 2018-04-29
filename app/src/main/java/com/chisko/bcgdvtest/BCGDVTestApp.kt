package com.chisko.bcgdvtest

import android.app.Application
import android.content.Context
import autodagger.AutoComponent
import autodagger.AutoExpose
import autodagger.AutoInjector
import dagger.Provides
import javax.inject.Singleton

@DaggerScope(BCGDVTestApp::class)
@AutoComponent(modules = [BCGDVTestApp.Module::class])
@AutoInjector
class BCGDVTestApp : Application() {

    val component: BCGDVTestAppComponent by lazy {
        DaggerBCGDVTestAppComponent.builder()
                .module(Module(this))
                .build()
    }

    @Singleton @dagger.Module
    internal class Module(private val app: BCGDVTestApp) {

        @Provides @AutoExpose(BCGDVTestApp::class) fun app() = app

        @Provides @AutoExpose(BCGDVTestApp::class) fun context() : Context {
            return app
        }
    }
}