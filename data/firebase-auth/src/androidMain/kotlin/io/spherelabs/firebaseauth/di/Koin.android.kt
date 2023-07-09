package io.spherelabs.firebaseauth.di


import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import io.spherelabs.firebaseauth.FirebaseAuthManager
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

actual fun platformModule() = module {
    single { FirebaseApp.initializeApp(androidContext()) }
    single { FirebaseAuth.getInstance() }
    single { FirebaseAuthManager(get()) }
}