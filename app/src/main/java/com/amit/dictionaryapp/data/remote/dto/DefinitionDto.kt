package com.amit.dictionaryapp.data.remote.dto


import com.amit.dictionaryapp.domain.model.DefinitionModel
import com.google.gson.annotations.SerializedName

data class DefinitionDto(
    @SerializedName("antonyms")
    val antonyms: List<String>,
    @SerializedName("definition")
    val definition: String?,
    @SerializedName("example")
    val example: String,
    @SerializedName("synonyms")
    val synonyms: List<Any>
){
    fun toDefinitionModel(): DefinitionModel{
        return  DefinitionModel(
            antonyms= antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}

