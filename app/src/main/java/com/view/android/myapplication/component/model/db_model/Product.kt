package com.view.android.myapplication.component.model.db_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val title: String,
    val description: String,
    val category: String,
)
