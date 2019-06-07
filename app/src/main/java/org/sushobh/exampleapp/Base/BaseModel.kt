package org.sushobh.exampleapp.Base

import com.google.firebase.firestore.FirebaseFirestore
import org.sushobh.exampleapp.Dagger.Components.DaggerModelBuilder
import org.sushobh.exampleapp.Dagger.Modules.RetrofitModule
import org.sushobh.exampleapp.Room.AppDatabase
import retrofit2.Retrofit
import javax.inject.Inject

abstract class BaseModel {


    public final var BASE_URL = "http://google.com"
    @Inject
    lateinit var retrofit : Retrofit;



    @Inject
    lateinit var firebaseFirestore: FirebaseFirestore
    @Inject
    lateinit var appDatabase: AppDatabase

    constructor(){
        DaggerModelBuilder.builder().retrofitModule(RetrofitModule(BASE_URL)).build().inject(this)
    }

}