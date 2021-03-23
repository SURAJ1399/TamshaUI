package net.developers.musicwiki.daggerhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import net.developers.ttamasha.retrofit.RetrofitInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providebaseurl():String{


        return  "https://us-central1-tamashaprod-602dd.cloudfunctions.net/api/"

        }


    @Singleton
    @Provides
    fun provideRetrofit(baseurl:String): Retrofit {

        val retrofit= Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return  retrofit

    }

    @Singleton
    @Provides
    fun provideInterface(retrofit: Retrofit): RetrofitInterface {

        val api=retrofit.create(RetrofitInterface::class.java)

        return api

    }



}