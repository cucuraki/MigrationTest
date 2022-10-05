package com.example.migrationtest.data.mapers

import com.example.migrationtest.data.local.database.Entity
import com.example.migrationtest.domain.models.Model

fun List<Entity>.toModel() = this.map { Model(it.id, it.name, it.age) }

fun List<Model>.toEntity() = this.map { Entity(name = it.name, age = it.age) }