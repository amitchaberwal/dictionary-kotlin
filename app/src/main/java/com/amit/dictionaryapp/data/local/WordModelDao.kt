package com.amit.dictionaryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amit.dictionaryapp.data.local.entities.WordModelEntity

@Dao
interface WordModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordModels( models: List<WordModelEntity> )

    @Query("DELETE FROM wordmodelentity WHERE word IN(:models)")
    suspend fun deleteWords(models: List<String>)

    @Query("SELECT * FROM wordmodelentity WHERE word LIKE '%' || :word || '%' ")
    suspend fun getWordInfo(word: String): List<WordModelEntity>
}