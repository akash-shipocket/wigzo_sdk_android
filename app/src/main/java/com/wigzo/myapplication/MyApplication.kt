package com.sample.samplewigzo

import com.google.firebase.FirebaseApp
import com.wigzo.android.Wigzo
import com.wigzo.android.base.WigzoApplication

class MyApplication : WigzoApplication() {
    override fun onCreate() {
        super.onCreate() //Always call this method first before writing any other logic.
        FirebaseApp.initializeApp(this)
        Wigzo.initialize("0oPogjIuR9yMLkKxxxhlbA", getApplicationContext())
        Wigzo.isDebugMode(true)
    }
}
