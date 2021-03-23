package net.developers.ttamasha.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import net.developers.musicwiki.repo.globalRepo
import net.developers.ttamasha.model.GetEventsItem


class GetEventViewModel
@ViewModelInject
    constructor(
        var globalRepo: globalRepo
    ):ViewModel(){

    var _tags=MutableLiveData<List<GetEventsItem>>()
    var tags :LiveData<List<GetEventsItem>> = _tags

    fun fetchevents() = CoroutineScope(Dispatchers.IO).launch {

        globalRepo.getEvents().body().apply {
          _tags.postValue(this)
            Log.i("resp",this.toString()+"jknjk")
        }
    }}