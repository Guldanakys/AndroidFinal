package com.example.guldana.finalapp.main

import android.content.Context
import com.example.guldana.finalapp.App
import kotlin.concurrent.thread

class MainPresenter(override var view: MainContract.View?) :
    MainContract.Presenter {

    override fun loadContacts(context: Context) {
        thread {

            val contactDao = (context as App).database.contactDao()

            (context as App).database.runInTransaction(object : Runnable {

                override fun run() {

                    val contacts = contactDao.getContacts()

                    view?.contactsShow(contacts)
                }
            })
        }
    }

}