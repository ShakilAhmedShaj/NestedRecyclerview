package com.decimalab.nestedrecyclerview.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decimalab.nestedrecyclerview.model.Item
import com.decimalab.nestedrecyclerview.repository.Repository
import java.util.*

class MainViewModel : ViewModel() {
    private val repository = Repository()
    val listMutableLiveData: MutableLiveData<ArrayList<Item>>
        get() = repository.listMutableLiveData

    init {
        repository.loadData()
    }
}