package com.junjange.lotto3.HomeRoom

import androidx.lifecycle.LiveData

class Home645Repository(mDatabase: Home645Database) {

    private val home645Dao = mDatabase.home645Dao()
    val Home645allUsers: LiveData<List<Home645Entity>> = home645Dao.getAlphabetizedUsers()

    companion object{
        private var sInstance: Home645Repository? = null
        fun getInstance(database: Home645Database): Home645Repository {
            return sInstance
                ?: synchronized(this){
                    val instance = Home645Repository(database)
                    sInstance = instance
                    instance
                }
        }
    }

    suspend fun insert(home645Entity: Home645Entity) {
        home645Dao.insert(home645Entity)
    }

    suspend fun delete(home645Entity: Home645Entity){
        home645Dao.delete(home645Entity)
    }
}
