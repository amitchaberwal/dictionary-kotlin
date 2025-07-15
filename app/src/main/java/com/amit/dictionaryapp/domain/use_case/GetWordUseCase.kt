package com.amit.dictionaryapp.domain.use_case

import com.amit.dictionaryapp.common.Resource
import com.amit.dictionaryapp.domain.model.WordModel
import com.amit.dictionaryapp.domain.repo.GetDictionaryRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordUseCase(
    private val repo: GetDictionaryRepo
) {
    operator fun invoke(word:String): Flow<Resource<List<WordModel>>> {
        if(word.isBlank()){
            return flow {  }
        }
            return repo.getWordDefinition(word)
    }
}