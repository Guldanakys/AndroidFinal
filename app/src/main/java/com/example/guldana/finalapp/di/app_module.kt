package com.example.guldana.finalapp.di

import com.example.guldana.finalapp.main.MainContract
import com.example.guldana.finalapp.main.MainPresenter
import org.koin.dsl.module.module

val appModule = module {
    factory { (view: MainContract.View) -> MainPresenter(view) as MainContract.Presenter }
}

val contactApp = listOf(appModule)