package com.junjange.lotto3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.junjange.lotto3.HomeRoom.Home645Database
import com.junjange.lotto3.HomeRoom.Home645Entity
import com.junjange.lotto3.HomeRoom.Home645Repository
import com.junjange.lotto3.Lotto645Room.Lotto645Database
import com.junjange.lotto3.Lotto645Room.Lotto645Entity
import com.junjange.lotto3.Lotto645Room.Repository645
import com.junjange.lotto3.Lotto720Room.Lotto720Database
import com.junjange.lotto3.Lotto720Room.Lotto720Entity
import com.junjange.lotto3.Lotto720Room.Repository720
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Lotto645
    val repository645: Repository645 =
        Repository645(Lotto645Database.getDatabase(application, viewModelScope))
    var allUsers645: LiveData<List<Lotto645Entity>> = repository645.allUsers645


    fun insert(lotto645Entity: Lotto645Entity) = viewModelScope.launch(Dispatchers.IO) {
        repository645.insert(lotto645Entity)
    }


    fun deleteAll(lotto645Entity: Lotto645Entity) = viewModelScope.launch(Dispatchers.IO) {
        repository645.delete(lotto645Entity)
    }


    // Lotto720
    val repository720: Repository720 =
        Repository720(Lotto720Database.getDatabase(application, viewModelScope))
    var allUsers720: LiveData<List<Lotto720Entity>> = repository720.allUsers720


    fun insert(lotto720Entity: Lotto720Entity) = viewModelScope.launch(Dispatchers.IO) {
        repository720.insert(lotto720Entity)
    }


    fun deleteAll(lotto720Entity: Lotto720Entity) = viewModelScope.launch(Dispatchers.IO) {
        repository720.delete(lotto720Entity)
    }

    // Home


    val home645repository: Home645Repository =
        Home645Repository(Home645Database.getDatabase(application, viewModelScope))
    var home645allUsers: LiveData<List<Home645Entity>> = home645repository.Home645allUsers




    fun insert(home645Entity: Home645Entity) = viewModelScope.launch(Dispatchers.IO) {
        home645repository.insert(home645Entity)
    }


    fun deleteAll(home645Entity: Home645Entity) = viewModelScope.launch(Dispatchers.IO) {
        home645repository.delete(home645Entity)
    }


}

