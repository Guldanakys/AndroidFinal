package com.example.guldana.finalapp

import android.app.Application
import android.arch.persistence.room.Room
import com.example.guldana.finalapp.di.contactApp
import org.koin.android.ext.android.startKoin

class App : Application() {

    lateinit var database: ProjectDatabase

    override fun onCreate() {
        super.onCreate()

        instance = this
        startKoin(this, contactApp)

        database = Room.databaseBuilder(applicationContext,
            ProjectDatabase::class.java,
            "ContactDb")
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        @JvmStatic var instance: App? = null
            private set
    }
}