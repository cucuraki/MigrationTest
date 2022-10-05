package com.example.migrationtest.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(vararg entity: Entity)

    @Query("select * from table_1")
    fun getData(): Flow<List<Entity>>

}