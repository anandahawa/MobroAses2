package com.example.mobproases2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobproases2.model.Bunga

@Database(entities = [Bunga::class], version = 1, exportSchema = false)
abstract class BungaDb : RoomDatabase() {

    abstract val dao: BungaDao

    companion object {
        @Volatile
        private var INSTANCE: BungaDb? = null

        fun getInstance(context: Context): BungaDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BungaDb::class.java,
                        "bunga.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}