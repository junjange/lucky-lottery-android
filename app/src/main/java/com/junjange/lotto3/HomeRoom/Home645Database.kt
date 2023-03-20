package com.junjange.lotto3.HomeRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.junjange.lotto3.Lotto645Room.Lotto645Dao
import com.junjange.lotto3.Lotto645Room.Lotto645Entity
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Home645Entity::class],   version = 1, exportSchema = false)
abstract class Home645Database : RoomDatabase() {

    abstract fun home645Dao(): Home645Dao

    companion object {
        @Volatile
        private var INSTANCE: Home645Database? = null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): Home645Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Home645Database::class.java,
                    "Home_app_database"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
