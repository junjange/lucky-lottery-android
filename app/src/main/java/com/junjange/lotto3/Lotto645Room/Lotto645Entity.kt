package com.junjange.lotto3.Lotto645Room

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lotto645_table")
data class Lotto645Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var number1: String,
    var number2: String,
    var number3: String,
    var number4: String,
    var number5: String,
    var number6: String,
)

