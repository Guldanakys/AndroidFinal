package com.example.guldana.finalapp.main

import android.content.Context
import com.example.guldana.finalapp.base.BasePresenter
import com.example.guldana.finalapp.base.BaseView
import com.example.guldana.finalapp.models.Contact

interface AddContactContract {
    interface View : BaseView<Presenter> {
        fun spinnerShow(optionsList: List<String>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadContactGroups(context: Context)
    }
}