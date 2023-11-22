package com.jam.periodictable.Db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TableViewModelFactory(private val repository: TableElementsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TableViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TableViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}