package com.alican.testapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alican.testapp.db.dao.ExampleDao
import com.alican.testapp.db.entity.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}