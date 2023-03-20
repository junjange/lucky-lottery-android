package com.junjange.lotto3.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

        private val _text = MutableLiveData<String>().apply {
            value = "준장이 바보"
        }
        val text: LiveData<String> = _text
    }
