package com.view.android.myapplication.component.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.view.android.myapplication.component.model.db_dao.ProductDao
import com.view.android.myapplication.component.model.db_model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
