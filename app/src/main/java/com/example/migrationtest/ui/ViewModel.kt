package com.example.migrationtest.ui

import android.graphics.ColorSpace
import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.migrationtest.domain.models.Model
import com.example.migrationtest.domain.usecases.InsertUserCase
import com.example.migrationtest.domain.usecases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val insUserCase: InsertUserCase,
    private val userCase: UseCase
) : ViewModel() {

    fun get(){
        viewModelScope.launch {
            userCase().collect{list->
                list.forEach{
                    d("testdb", it.toString())
                }
            }
        }
    }

    fun insert(){
        val list = mutableListOf<Model>()
        for(i in 0..10){
            list.add(Model(i, "name$i", i))
        }
        viewModelScope.launch {
            insUserCase(list)
        }
    }


}