package com.junjange.lotto3.HomeRoom

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.junjange.lotto3.Lotto645Room.Lotto645Entity

@Dao
interface Home645Dao {

    @Query("SELECT * from home645_table  ORDER BY id DESC")
    fun getAlphabetizedUsers(): LiveData<List<Home645Entity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(home645Entity: Home645Entity)

    @Delete
    fun delete(home645Entity: Home645Entity)

    @Query("DELETE FROM home645_table")
    suspend fun deleteAll()


}
