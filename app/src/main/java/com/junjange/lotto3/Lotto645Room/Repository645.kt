package com.junjange.lotto3.Lotto645Room

import androidx.lifecycle.LiveData

class Repository645(mDatabase: Lotto645Database) {

    private val lotto645Dao = mDatabase.lotto645Dao()
    val allUsers645: LiveData<List<Lotto645Entity>> = lotto645Dao.getAlphabetizedUsers()

    companion object{
        private var sInstance: Repository645? = null
        fun getInstance(database: Lotto645Database): Repository645 {
            return sInstance
                ?: synchronized(this){
                    val instance = Repository645(database)
                    sInstance = instance
                    instance
                }
        }
    }

    suspend fun insert(lotto645Entity: Lotto645Entity) {
        lotto645Dao.insert(lotto645Entity)
    }

    suspend fun delete(lotto645Entity: Lotto645Entity){
        lotto645Dao.delete(lotto645Entity)
    }
}
