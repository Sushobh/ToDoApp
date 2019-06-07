package org.sushobh.exampleapp.Dagger.Modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import org.sushobh.exampleapp.Models.TaskModel
import org.sushobh.exampleapp.Models.UserModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
class ModelsModule {

    @Provides
    @Singleton
    internal fun userModel (): UserModel {
        return UserModel();
    }

    @Provides
    @Singleton
    internal fun taskModel (): TaskModel {
        return TaskModel();
    }




}