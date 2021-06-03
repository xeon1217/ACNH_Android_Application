package com.jungyoon.acnh_android_application.ui.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    protected val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _showMessageEvent = MutableLiveData<String>()
    val showMessageEvent: LiveData<String> = _showMessageEvent

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    protected fun showMessage(@StringRes stringResId: Int) {
        _showMessageEvent.value = getApplication<Application>().getString(stringResId)
    }
}