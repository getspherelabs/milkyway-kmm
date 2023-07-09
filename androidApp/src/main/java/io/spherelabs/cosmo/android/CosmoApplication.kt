package io.spherelabs.cosmo.android

import android.app.Application
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import io.spherelabs.cosmo.android.di.viewModelModule
import io.spherelabs.cosmo.di.initKoin
import org.koin.android.ext.koin.androidContext

class CosmoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@CosmoApplication)
            modules(viewModelModule)
        }
    }
}