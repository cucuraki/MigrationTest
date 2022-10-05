package com.example.migrationtest.data.repository

import com.example.migrationtest.data.local.database.Dao
import com.example.migrationtest.data.mapers.toEntity
import com.example.migrationtest.data.mapers.toModel
import com.example.migrationtest.domain.models.Model
import com.example.migrationtest.domain.repositorys.Repository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepositoryImpl @Inject constructor(private val dao: Dao) : Repository {
    override fun getData(): Flow<List<Model>> = dao.getData().map {
        it.toModel()
    }

    override suspend fun insert(models: List<Model>) {
        dao.insert(*(models.toEntity().toTypedArray()))
    }
}