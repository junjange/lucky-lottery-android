package com.junjange.lotto3.Lotto645Room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
@Dao
interface Lotto645Dao {

    @Query("SELECT * from lotto645_table  ORDER BY id DESC")
    fun getAlphabetizedUsers(): LiveData<List<Lotto645Entity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(lotto645Entity: Lotto645Entity)

    @Delete
    fun delete(lotto645Entity: Lotto645Entity)

    @Query("DELETE FROM lotto645_table")
    suspend fun deleteAll()


}

