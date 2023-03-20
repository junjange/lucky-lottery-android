package com.junjange.lotto3.Lotto720Room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
@Dao
interface Lotto720Dao {

    @Query("SELECT * from lotto720_table ORDER BY id DESC")
    fun getAlphabetizedUsers(): LiveData<List<Lotto720Entity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(lotto720Entity: Lotto720Entity)

    @Delete
    fun delete(lotto720Entity: Lotto720Entity)

    @Query("DELETE FROM lotto720_table")
    suspend fun deleteAll()
}

