package com.example.guldana.finalapp.di

import com.example.guldana.finalapp.main.AddContactContract
import com.example.guldana.finalapp.main.AddContactPresenter
import com.example.guldana.finalapp.main.MainContract
import com.example.guldana.finalapp.main.MainPresenter
import org.koin.dsl.module.module

val appModule = module {
    factory { (view: MainContract.View) -> MainPresenter(view) as MainContract.Presenter }
    factory { (view: AddContactContract.View) -> AddContactPresenter(view) as AddContactContract.Presenter }
}

val contactApp = listOf(appModule)