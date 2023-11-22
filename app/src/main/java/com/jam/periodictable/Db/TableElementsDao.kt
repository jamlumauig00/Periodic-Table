package com.jam.periodictable.Db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface TableElementsDao {
    @Query("SELECT * FROM tableName")
    fun getAllTableElements(): LiveData<List<TableElementModel>>

    @Query("SELECT * FROM tableName WHERE AtomicNumber = :id")
   // suspend fun getTableElementById(id: String): TableElement
    fun getTableElementById(id: String): LiveData<List<TableElementModel>>

}
