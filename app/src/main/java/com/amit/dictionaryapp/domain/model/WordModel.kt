package com.amit.dictionaryapp.domain.model

import com.amit.dictionaryapp.data.local.entities.WordModelEntity

data class WordModel(
    val meanings: List<MeaningModel>,
    val word: String
){
    fun toWordEntity(): WordModelEntity{
        return WordModelEntity(
            meanings = meanings,
            word = word
        )
    }
}
