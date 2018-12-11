package com.example.guldana.finalapp.main

import android.content.Context
import com.example.guldana.finalapp.App
import com.example.guldana.finalapp.models.Contact
import kotlin.concurrent.thread

class AddContactPresenter(override var view: AddContactContract.View?) :
    AddContactContract.Presenter {

    override fun loadContactGroups(context: Context) {
        thread {

            val contactGroupDao = (context as App).database.contactGroupDao()

            (context as App).database.runInTransaction(object : Runnable {

                override fun run() {

                    val priorities = contactGroupDao.getGroupsPriority()

                    view?.spinnerShow(priorities)
                }
            })
        }
    }
}