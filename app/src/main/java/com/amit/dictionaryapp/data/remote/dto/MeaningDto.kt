package com.amit.dictionaryapp.data.remote.dto


import com.amit.dictionaryapp.domain.model.MeaningModel
import com.google.gson.annotations.SerializedName

data class MeaningDto(
    @SerializedName("antonyms")
    val antonyms: List<String>,
    @SerializedName("definitions")
    val definitions: List<DefinitionDto>,
    @SerializedName("partOfSpeech")
    val partOfSpeech: String,
    @SerializedName("synonyms")
    val synonyms: List<String>
){
    fun toMeaningModel(): MeaningModel{
        return MeaningModel(
            definitions = definitions.map { it.toDefinitionModel() },
            partOfSpeech = partOfSpeech
        )
    }

}