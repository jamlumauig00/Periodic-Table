package com.jam.periodictable.Db

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object DatabaseCopier {
    fun copyDatabaseFromAssets(context: Context) {
        val databasePath = context.getDatabasePath("PeriodicTableDB3.db").absolutePath

        if (!File(databasePath).exists()) {
            val inputStream = context.assets.open("PeriodicTableDB3.db")
            val outputStream = FileOutputStream(databasePath)

            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
        }
    }
}

