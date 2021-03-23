package net.developers.ttamasha.retrofit

import net.developers.ttamasha.model.GetEvents
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitInterface
{


    @GET("events/get")
        suspend fun getEvents(

        ):Response<GetEvents>



}