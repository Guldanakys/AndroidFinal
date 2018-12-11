package com.example.guldana.finalapp.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.guldana.finalapp.App
import com.example.guldana.finalapp.R
import com.example.guldana.finalapp.models.Contact
import com.example.guldana.finalapp.models.ContactGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), MainContract.View {

    override val presenter: MainContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadContacts(applicationContext)
        /*thread {

            val groupDao = (applicationContext as App).database.contactGroupDao()
            val contactDao = (applicationContext as App).database.contactDao()

            (applicationContext as App).database.runInTransaction(object : Runnable {

                override fun run() {

                    val group1 = ContactGroup(1, "Family", 1)
                    val group2 = ContactGroup(2, "Friends", 2)
                    val contact1 = Contact(1, "Sam", "1111", "2222",
                        "3333", "fdrtg", 1)

                    groupDao.insert(group1)
                    groupDao.insert(group2)
                    contactDao.insert(contact1)

                    val groups = groupDao.getGroups()
                    for (g in groups) {
                        Log.d("Group", g.name)
                    }

                    val contacts = contactDao.getContacts()
                    for (c in contacts) {
                        Log.d("Contact", c.name)
                    }

                }
            })
        }*/


    }

    override fun contactsShow(contactsList: List<Contact>) {
        val adapter = ContactListAdapter(contactsList)
        val recyclerView = findViewById(R.id.recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}
