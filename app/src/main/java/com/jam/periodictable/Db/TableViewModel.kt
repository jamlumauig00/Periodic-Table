package com.jam.periodictable.Db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TableViewModel(repository: TableElementsRepository) : ViewModel() {
    val allData: LiveData<List<TableElementModel>> = repository.getAlldata()

    fun getAllDatas(): LiveData<List<TableElementModel>> {
        return allData
    }
}
