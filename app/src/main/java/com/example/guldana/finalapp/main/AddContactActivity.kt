package com.example.guldana.finalapp.main

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.guldana.finalapp.R
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.list_item.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AddContactActivity : AppCompatActivity(), AddContactContract.View {

    override val presenter: AddContactContract.Presenter by inject { parametersOf(this) }

    lateinit var priority : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        presenter.loadContactGroups(applicationContext)

        btn_save.setOnClickListener {
            val result = Intent()
            result.putExtra("contact_name", edx_name.text.toString())
            result.putExtra("contact_mobile", edx_mobile.text.toString())
            result.putExtra("contact_home", edx_home.text.toString())
            result.putExtra("contact_work", edx_work.text.toString())
            result.putExtra("contact_group", priority)
            setResult(Activity.RESULT_OK, result)
            finish()
        }


    }


    override fun spinnerShow(optionsList: List<String>) {
        val spAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsList)
        spAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        my_spinner.adapter = spAdapter
        my_spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                priority = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>){

            }
        }
    }

}
