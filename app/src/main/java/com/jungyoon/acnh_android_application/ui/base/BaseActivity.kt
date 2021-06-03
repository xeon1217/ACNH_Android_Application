package com.jungyoon.acnh_android_application.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.jungyoon.acnh_android_application.R
import com.jungyoon.acnh_android_application.extension.TAG

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        afterBinding()

        Log.d(TAG, "onCreate!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy!")
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView<B>(this, getLayoutId()).apply {
            lifecycleOwner = this@BaseActivity
        }
    }

    protected abstract fun afterBinding()

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}