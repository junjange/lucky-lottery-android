package com.junjange.lotto3.ui.randomnumber

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel: ViewModel() {

        private val _text = MutableLiveData<String>().apply {
            value = "This is randomnumber Fragment"
        }
        val text: LiveData<String> = _text
    }
