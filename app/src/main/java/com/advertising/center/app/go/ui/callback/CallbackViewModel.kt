package com.advertising.center.app.go.ui.callback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallbackViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is callback Fragment"
    }
    val text: LiveData<String> = _text
}