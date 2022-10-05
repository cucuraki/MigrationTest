package com.example.migrationtest.data.local.database

import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import javax.inject.Inject


@Database(
    entities = [Entity::class, NewEntity::class],
    version = 5
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getDao(): Dao

    @RenameColumn(tableName = "table_1", fromColumnName = "newInt", toColumnName = "newInt1")
    class Migration2To3 : AutoMigrationSpec

    @DeleteColumn(tableName = "table_1", columnName = "newInt1")
    class Migration3To4 : AutoMigrationSpec


}


object MIGRATION_4_5 : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE table_2(id int not null primary key)")
    }
}

class Migrations @Inject constructor() {
    fun getMigrations(): List<Migration> {
        return listOf(object : Migration(4, 5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE table_2(id int not null primary key)")
            }
        })
    }
}
// AutoMigration(from = 2, to = 3, spec = MyDatabase.Migration2To3::class),
//AutoMigration(from = 3, to = 4, spec = MyDatabase.Migration3To4::class)