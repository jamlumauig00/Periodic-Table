package com.jam.periodictable.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TableElementModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Define your DAOs here
    abstract fun tableElementsDao(): TableElementsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "PeriodicTableDB3")
                        .createFromAsset("PeriodicTableDB3.db")
                        .build()
                }
            }
            return INSTANCE!!
        }

       /* fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val databasePath = context.getDatabasePath("PeriodicTableDB.db").absolutePath
                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, databasePath)
                    .build()

                INSTANCE = instance
                instance
            }
        }*/
    }
}


