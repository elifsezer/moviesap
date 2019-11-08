package com.example.moviesap.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

//databinding hem de viewmodel olacağı için generic yazıyoruz.
//AppCompatActivity bütün aktivilerden AppCompatActivity türetildiği için
abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    //databinding tanımlıyoruz.
    lateinit var dataBinding: DB
    lateinit var viewModel: VM

    ///r.layout.res bu şekilde aldık.
    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel():Class<VM>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel= ViewModelProviders.of(this).get(getViewModel())
    }
}