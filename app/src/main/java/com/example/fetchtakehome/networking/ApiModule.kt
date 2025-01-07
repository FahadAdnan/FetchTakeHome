package com.example.fetchtakehome.networking

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun gson(
    ): Gson = GsonBuilder()
        .setLenient().create()

    @Singleton
    @Provides
    fun okHttpClient(
    ): OkHttpClient = OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun api(
        retrofitFactory: RetrofitFactory,
        okHttpClient: OkHttpClient
    ): Api =
        retrofitFactory.getRetrofit(
            "https://fetch-hiring.s3.amazonaws.com/",
            okHttpClient
        ).create(Api::class.java)
}