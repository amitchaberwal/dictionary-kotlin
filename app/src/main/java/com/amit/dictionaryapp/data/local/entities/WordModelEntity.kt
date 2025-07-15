package com.amit.dictionaryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amit.dictionaryapp.domain.model.MeaningModel
import com.amit.dictionaryapp.domain.model.WordModel

@Entity
data class WordModelEntity(
    val meanings: List<MeaningModel>,
    val word: String,
    @PrimaryKey
    val id: Int? = null
){
    fun toWordModel(): WordModel {
        return WordModel(
            meanings = meanings,
            word = word
        )
    }
}
