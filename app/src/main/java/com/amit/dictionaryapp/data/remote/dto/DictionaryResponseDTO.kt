package com.amit.dictionaryapp.data.remote.dto


import com.amit.dictionaryapp.domain.model.WordModel
import com.google.gson.annotations.SerializedName

data class DictionaryResponseDTO(
    @SerializedName("license")
    val license: License,
    @SerializedName("meanings")
    val meanings: List<MeaningDto>,
    @SerializedName("phonetics")
    val phonetics: List<PhoneticDto>,
    @SerializedName("sourceUrls")
    val sourceUrls: List<String>,
    @SerializedName("word")
    val word: String
){
    fun toWordModel(): WordModel{
        return WordModel(
            meanings = meanings.map { it.toMeaningModel() },
            word = word,
        )
    }
}