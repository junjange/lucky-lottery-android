package com.junjange.lotto3.Lotto720Room

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lotto720_table")
data class  Lotto720Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var number0: String,
    var number1: String,
    var number2: String,
    var number3: String,
    var number4: String,
    var number5: String,
    var number6: String,

)
