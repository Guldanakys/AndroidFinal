package com.example.guldana.finalapp.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.finalapp.App
import com.example.guldana.finalapp.R
import com.example.guldana.finalapp.models.Contact
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.concurrent.thread

class ContactListAdapter(private val contacts: List<Contact>,
                         private val myContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var groupName: String = ""

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.txt_name.text = contacts[p1].name
        thread {
            val contactGroupDao = (myContext as App).database.contactGroupDao()
            (myContext as App).database.runInTransaction(object : Runnable {

                override fun run() {
                    val groups = contactGroupDao.getGroups()

                    for(g in groups) {
                        if(g.gid == contacts[p1].group_id) {
                            groupName = g.name
                        }
                    }
                }
            })
        }
        p0.itemView.txt_group.text = groupName
        p0.itemView.setOnClickListener {
            val intent = Intent(myContext, DetailsActivity::class.java)
            //startActivity(intent)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ContactsViewHolder(
            LayoutInflater.from(p0.context)
                .inflate(R.layout.list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ContactsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
}