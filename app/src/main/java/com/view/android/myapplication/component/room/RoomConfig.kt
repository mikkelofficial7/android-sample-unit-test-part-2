package com.view.android.myapplication.component.room

import android.content.Context
import androidx.room.Room

object RoomConfig {
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "db-name"
        ).build()
    }
}