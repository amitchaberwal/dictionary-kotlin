package com.amit.dictionaryapp.domain.repo

import com.amit.dictionaryapp.common.Resource
import com.amit.dictionaryapp.domain.model.WordModel
import kotlinx.coroutines.flow.Flow

interface GetDictionaryRepo {
     fun getWordDefinition(word: String): Flow<Resource<List<WordModel>>>
}