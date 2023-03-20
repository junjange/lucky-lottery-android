package com.junjange.lotto3.HomeRoom

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "home645_table")
data class Home645Entity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    var drwNo: String,
    var drwNoDate: String,
    var number1: String,
    var number2: String,
    var number3: String,
    var number4: String,
    var number5: String,
    var number6: String,
    var number7: String,
)

