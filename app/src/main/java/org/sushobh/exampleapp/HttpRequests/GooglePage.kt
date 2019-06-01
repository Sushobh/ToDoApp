package org.sushobh.exampleapp.HttpRequests

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*

interface GooglePageApi {

    @GET
    fun getGooglePage(@Url url : String) : Observable<String>;
}