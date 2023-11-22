package com.jam.periodictable.Db

import androidx.lifecycle.LiveData

class TableElementsRepository(private val tableElementsDao: TableElementsDao) {

 val getAlldata : LiveData<List<TableElementModel>> = tableElementsDao.getAllTableElements()

  //val allData: LiveData<List<YourEntity>> = yourDao.getAllData()

  fun getAlldata(): LiveData<List<TableElementModel>> {
    return tableElementsDao.getAllTableElements()
  }

}
