package com.example.guldana.finalapp.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.guldana.finalapp.models.ContactGroup

@Dao
interface ContactGroupDao {

    @Insert
    fun insert(contactGroup: ContactGroup)

    @Query("Select * from groups")
    fun getGroups () : List<ContactGroup>

}