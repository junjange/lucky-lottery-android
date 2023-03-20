package com.junjange.lotto3.Lotto720Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Lotto720Entity::class], version = 1, exportSchema = false)
abstract class Lotto720Database : RoomDatabase() {

    abstract fun lotto720Dao(): Lotto720Dao

    companion object {
        @Volatile
        private var INSTANCE: Lotto720Database? = null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): Lotto720Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Lotto720Database::class.java,
                    "app_database720"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

