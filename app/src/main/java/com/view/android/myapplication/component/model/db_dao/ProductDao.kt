package com.view.android.myapplication.component.model.db_dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.view.android.myapplication.component.model.db_model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM product where uid = :id")
    fun getProductById(id: String): Product?

    @Insert
    fun insert(products: Product)

    @Delete
    fun delete(product: Product)
}