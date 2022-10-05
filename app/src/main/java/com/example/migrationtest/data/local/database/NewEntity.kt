package com.example.migrationtest.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_2")
data class NewEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)