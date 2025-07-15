package com.amit.dictionaryapp.domain.model

data class MeaningModel(
    val definitions: List<DefinitionModel>,
    val partOfSpeech: String,
)
