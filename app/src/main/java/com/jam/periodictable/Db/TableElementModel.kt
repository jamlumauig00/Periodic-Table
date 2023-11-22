package com.jam.periodictable.Db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableName")
data class TableElementModel(
    @PrimaryKey val AtomicNumber: String = "",
    val Element: String?,
    val Symbol: String?,
    val AtomicMass: String?,
    val NumberofNeutrons : String?,
    val NumberofProtons: String?,
    val NumberofElectrons: String?,
    val Period: String?,
    val Groups: String?,
    val Type: String?,
    val AtomicRadius: String?,
    val Electronegativity: String?,
    val MeltingPoint: String?,
    val BoilingPoint: String?,
    val Discoverer: String?,
    val UsesAndImportance: String?,
    val UsesAndImportance2: String?,
    val UsesAndImportance3: String?,
    val Links: String?,
    val Description: String?,
    val Year: String?
)

