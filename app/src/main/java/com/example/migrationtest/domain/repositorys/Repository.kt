package com.example.migrationtest.domain.repositorys

import android.view.Display
import com.example.migrationtest.domain.models.Model
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<List<Model>>
    suspend fun insert(models: List<Model>)
}