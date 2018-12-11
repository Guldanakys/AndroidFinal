package com.example.guldana.finalapp.main

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guldana.finalapp.R
import com.example.guldana.finalapp.models.Contact
import kotlinx.android.synthetic.main.list_item.view.*

class ContactListAdapter(private val contacts: List<Contact>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.txt_name.text = contacts[p1].name
        p0.itemView.txt_mobile.text = contacts[p1].mobileNumber
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