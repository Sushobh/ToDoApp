package org.sushobh.exampleapp.Dagger.Modules

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class FireBaseModule {
    @Provides
    @Singleton
    internal fun provideRetrofit (): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}