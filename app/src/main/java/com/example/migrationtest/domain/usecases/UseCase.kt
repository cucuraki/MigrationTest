package com.example.migrationtest.domain.usecases

import com.example.migrationtest.domain.repositorys.Repository
import javax.inject.Inject

class UseCase @Inject constructor(private val repo: Repository) {
    operator fun invoke() = repo.getData()
}