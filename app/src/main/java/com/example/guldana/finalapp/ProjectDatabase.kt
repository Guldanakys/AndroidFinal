package com.example.guldana.finalapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.guldana.finalapp.daos.ContactDao
import com.example.guldana.finalapp.daos.ContactGroupDao
import com.example.guldana.finalapp.models.Contact
import com.example.guldana.finalapp.models.ContactGroup

@Database(entities = [Contact::class, ContactGroup::class], version = 1)
abstract class ProjectDatabase : RoomDatabase(){

    abstract fun contactDao(): ContactDao

    abstract fun contactGroupDao(): ContactGroupDao
}