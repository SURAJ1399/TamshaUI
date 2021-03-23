package net.developers.musicwiki.repo

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext

import net.developers.ttamasha.retrofit.RetrofitInterface
import javax.inject.Inject

class globalRepo
@Inject
constructor(
    val retrofitInterface: RetrofitInterface,
    @ActivityContext
    val context: Context
){




       suspend fun getEvents()=retrofitInterface.getEvents()



}