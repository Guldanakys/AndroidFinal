package com.example.guldana.finalapp.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.guldana.finalapp.models.Contact

@Dao
interface ContactDao {

    @Insert
    fun insert(contact: Contact)

    @Query("Select * from contacts")
    fun getContacts () : List<Contact>

}