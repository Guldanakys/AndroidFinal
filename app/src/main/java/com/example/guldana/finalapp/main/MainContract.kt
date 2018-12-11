package com.example.guldana.finalapp.main

import android.content.Context
import com.example.guldana.finalapp.base.BasePresenter
import com.example.guldana.finalapp.base.BaseView
import com.example.guldana.finalapp.models.Contact

interface MainContract {
    interface View : BaseView<Presenter> {
        fun contactsShow(contactsList: List<Contact>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadContacts(context: Context)
    }
}