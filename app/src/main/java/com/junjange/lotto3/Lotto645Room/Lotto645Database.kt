package com.junjange.lotto3.Lotto645Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Lotto645Entity::class],   version = 1, exportSchema = false)
abstract class Lotto645Database : RoomDatabase() {

    abstract fun lotto645Dao(): Lotto645Dao

    companion object {
        @Volatile
        private var INSTANCE: Lotto645Database? = null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): Lotto645Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Lotto645Database::class.java,
                    "app_database645"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}


