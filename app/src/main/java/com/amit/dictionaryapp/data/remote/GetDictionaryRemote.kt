package com.amit.dictionaryapp.data.remote

import com.amit.dictionaryapp.data.remote.dto.DictionaryResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface GetDictionaryRemote{
    @GET("v2/entries/en/{word}")
    suspend fun getWordMeaning(@Path("word") word: String) : List<DictionaryResponseDTO>
}