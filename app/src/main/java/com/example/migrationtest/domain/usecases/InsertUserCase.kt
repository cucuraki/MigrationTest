package com.example.migrationtest.domain.usecases


import com.example.migrationtest.domain.models.Model
import com.example.migrationtest.domain.repositorys.Repository
import javax.inject.Inject

class InsertUserCase @Inject constructor(private val repo: Repository) {

    suspend operator fun invoke(models: List<Model>) {
        repo.insert(models)
    }
}