package org.sushobh.exampleapp.Dagger.Modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import org.sushobh.exampleapp.HttpRequests.GooglePageApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule (var baseUrl : String) {



    @Provides
    internal
    fun provideGooglePageApi (retrofit : Retrofit) : GooglePageApi {
        return retrofit.create(GooglePageApi::class.java);
    }



    @Provides
    @Singleton
    internal fun provideRetrofit (): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
    }
}