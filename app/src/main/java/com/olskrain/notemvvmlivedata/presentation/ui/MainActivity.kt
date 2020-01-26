package com.olskrain.notemvvmlivedata.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.olskrain.notemvvmlivedata.R
import com.olskrain.notemvvmlivedata.presentation.viewmodel.MainViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //делаем связывание с нашего MainActivity и MainViewModelImpl
        //почему у нас MainViewModelImpl::class.java? - потому что сама библиотека написана на java
        //и нас нужен java класс. А MainViewModelImpl::class - это kotlin класс
        viewModel = ViewModelProviders.of(this).get(MainViewModelImpl::class.java)

        //когда мы в классе MainViewModelImpl изменяем value у liveData, то стреляет этот Observer
        viewModel.viewState().observe(this, Observer { value ->
            value?.let {
                textView.text = it
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        random.setOnClickListener { viewModel.getRandomValue() }
    }
}
