package com.amit.dictionaryapp.data.repo

import com.amit.dictionaryapp.common.Resource
import com.amit.dictionaryapp.data.local.WordModelDao
import com.amit.dictionaryapp.data.remote.GetDictionaryRemote
import com.amit.dictionaryapp.domain.model.WordModel
import com.amit.dictionaryapp.domain.repo.GetDictionaryRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetDictionaryRepoImpl @Inject constructor(
    private val api: GetDictionaryRemote,
    private val dao: WordModelDao
) : GetDictionaryRepo {
    override fun getWordDefinition(word: String): Flow<Resource<List<WordModel>>> = flow {
        emit(Resource.Loading<List<WordModel>>())
        val cachedWord = dao.getWordInfo(word).map { it.toWordModel() }
        emit(Resource.Loading<List<WordModel>>(data = cachedWord))
        try {
            val remoteWords = api.getWordMeaning(word)
            dao.deleteWords(remoteWords.map { it.word })
            dao.insertWordModels(remoteWords.map { it.toWordModel().toWordEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error<List<WordModel>>(message = "Error", data = cachedWord))
        } catch (e: Exception) {
            emit(Resource.Error<List<WordModel>>(message = "Error", data = cachedWord))
        }
        val newWordInfo = dao.getWordInfo(word).map { it.toWordModel() }
        emit(Resource.Success<List<WordModel>>(data = newWordInfo))
    }
}