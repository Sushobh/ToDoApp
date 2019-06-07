package org.sushobh.exampleapp.Models

import io.reactivex.Observable
import org.sushobh.exampleapp.Base.BaseModel
import org.sushobh.exampleapp.Dagger.Components.DaggerModelBuilder

import org.sushobh.exampleapp.Dagger.Modules.RetrofitModule
import org.sushobh.exampleapp.Dagger.Modules.RoomDatabaseModule
import org.sushobh.exampleapp.HttpRequests.GooglePageApi
import org.sushobh.exampleapp.Room.AppDatabase
import org.sushobh.exampleapp.Room.Entity.User

import retrofit2.Retrofit

import javax.inject.Inject

class MainModel : BaseModel() {








      fun getGooglePage() : GooglePageApi {
        return retrofit.create(GooglePageApi::class.java);
      }

      fun addDummyUser(){
          appDatabase.userDao().insert(User("Sushobh Nadiger","Mumbai",100))
      }

    fun getAllUsers () : List<User>{
       return appDatabase.userDao().getAll()
    }
}