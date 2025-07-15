package com.amit.dictionaryapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.amit.dictionaryapp.common.Constants
import com.amit.dictionaryapp.data.local.Converters
import com.amit.dictionaryapp.data.local.WordModelDao
import com.amit.dictionaryapp.data.local.WordModelDatabase
import com.amit.dictionaryapp.data.remote.GetDictionaryRemote
import com.amit.dictionaryapp.data.repo.GetDictionaryRepoImpl
import com.amit.dictionaryapp.data.utils.GsonParser
import com.amit.dictionaryapp.domain.repo.GetDictionaryRepo
import com.amit.dictionaryapp.domain.use_case.GetWordUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getDictionaryApi(retrofit: Retrofit): GetDictionaryRemote {
        return retrofit.create(GetDictionaryRemote::class.java)
    }

    @Singleton
    @Provides
    fun wordModelDatabase(app: Application): WordModelDatabase {
        return Room.databaseBuilder(
            app,
            WordModelDatabase::class.java,
            "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Singleton
    @Provides
    fun provideWordModelDao(wordModelDatabase: WordModelDatabase): WordModelDao {
        return wordModelDatabase.dao
    }

    @Singleton
    @Provides
    fun provideWordModelRepo(
        worldModelDao: WordModelDao,
        api: GetDictionaryRemote
    ): GetDictionaryRepo {
        return GetDictionaryRepoImpl(api, worldModelDao)
    }

    @Singleton
    @Provides
    fun provideWordModelUseCase(
        repo: GetDictionaryRepo
    ): GetWordUseCase {
        return GetWordUseCase(repo)
    }
}