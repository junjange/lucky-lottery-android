package com.junjange.lotto3.Lotto720Room

import androidx.lifecycle.LiveData

class Repository720(mDatabase: Lotto720Database) {

    private val lotto720Dao = mDatabase.lotto720Dao()
    val allUsers720: LiveData<List<Lotto720Entity>> = lotto720Dao.getAlphabetizedUsers()

    companion object{
        private var sInstance: Repository720? = null
        fun getInstance(database: Lotto720Database): Repository720 {
            return sInstance
                ?: synchronized(this){
                    val instance = Repository720(database)
                    sInstance = instance
                    instance
                }
        }
    }

    suspend fun insert(lotto720Entity: Lotto720Entity) {
        lotto720Dao.insert(lotto720Entity)
    }

    suspend fun delete(lotto720Entity: Lotto720Entity){
        lotto720Dao.delete(lotto720Entity)
    }
}