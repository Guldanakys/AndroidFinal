package com.example.guldana.finalapp.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contacts", foreignKeys = [ForeignKey(entity = ContactGroup::class,
    parentColumns = arrayOf("gid"),
    childColumns = arrayOf("group_id"),
    onDelete = ForeignKey.CASCADE)]
)
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val cid : Int,

    val name : String,

    val mobileNumber : String,

    val homeNumber : String,

    val workNumber : String,

    val image : String,

    @ColumnInfo(name = "group_id")
    val group_id : Int

)