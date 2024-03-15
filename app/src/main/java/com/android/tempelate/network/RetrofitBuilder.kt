package com.android.tempelate.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {

    private const val BASE_URL = "https://api.github.com/"
    @Singleton
    @Provides
     fun getRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

/*    @Singleton
    @Provides
    fun providePokeService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)*/

    //@Provides
   // val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}