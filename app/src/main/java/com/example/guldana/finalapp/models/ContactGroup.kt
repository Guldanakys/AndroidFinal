package com.example.guldana.finalapp.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "groups")
data class ContactGroup(

    @PrimaryKey(autoGenerate = true)
    val gid : Int,

    val name : String,

    val priority : Int
)