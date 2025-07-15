package com.amit.dictionaryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amit.dictionaryapp.data.local.entities.WordModelEntity


@Database(
    entities = [WordModelEntity :: class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class WordModelDatabase: RoomDatabase() {
    abstract val dao : WordModelDao
}