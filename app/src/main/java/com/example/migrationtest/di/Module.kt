package com.example.migrationtest.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.example.migrationtest.data.local.database.Dao
import com.example.migrationtest.data.local.database.MIGRATION_4_5
import com.example.migrationtest.data.local.database.Migrations
import com.example.migrationtest.data.local.database.MyDatabase
import com.example.migrationtest.data.repository.RepositoryImpl
import com.example.migrationtest.domain.repositorys.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context, migrations: Migrations): MyDatabase =
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "db"
        ).addMigrations(*(migrations.getMigrations()).toTypedArray()).build()

    @Provides
    @Singleton
    fun getDao(db: MyDatabase): Dao = db.getDao()

    @Provides
    @Singleton
    fun getRepository(dao: Dao): Repository = RepositoryImpl(dao)
}