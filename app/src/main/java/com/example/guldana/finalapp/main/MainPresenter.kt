package com.example.guldana.finalapp.main

import android.content.Context
import com.example.guldana.finalapp.App
import com.example.guldana.finalapp.models.Contact
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

    override fun saveContact(name: String, mobile: String, home: String, work: String, group:String, context: Context) {
        thread {

            val contactDao = (context as App).database.contactDao()
            val contactGroupDao = (context as App).database.contactGroupDao()

            (context as App).database.runInTransaction(object : Runnable {

                override fun run() {
                    val priorities = contactGroupDao.getGroupsPriority()
                    var groupId: Int = 1
                    for(g in priorities) {
                        if(g.equals("Friends"))
                            groupId = 2
                        else if(g.equals("Family"))
                            groupId = 1
                    }

                    val size = contactDao.getContacts().size
                    val contact = Contact(size+1, name, mobile, home, work, "qwe", groupId)
                    contactDao.insert(contact)
                }
            })
        }

    }

}