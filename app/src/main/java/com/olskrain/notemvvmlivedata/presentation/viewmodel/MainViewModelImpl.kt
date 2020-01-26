package com.olskrain.notemvvmlivedata.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

/**
 * Created by Andrey Ievlev on 27,Январь,2020
 */
class MainViewModelImpl: MainViewModel, ViewModel() {

    //Объявляем liveData, но из вне её ни кто изменить не может. И сразу задаем ей значение
    private val liveData: MutableLiveData<String> = MutableLiveData<String>()
        .apply { value = "Hello World!" }

    override fun getRandomValue() {
        liveData.value = Random.nextInt(10).toString()
    }

    //предоставляем наружу нажу liveData
    fun viewState(): LiveData<String> =
        liveData
}