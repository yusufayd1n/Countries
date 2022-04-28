package com.example.countrylist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylist.model.CountryModel
import com.example.countrylist.model.CountryModelItem
import com.example.countrylist.service.API
import com.example.countrylist.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainViewModel:ViewModel() {

    lateinit var liveDataList:MutableLiveData<List<CountryModelItem>>
    init {
        liveDataList= MutableLiveData()
    }


    fun getLiveDataObserver():MutableLiveData<List<CountryModelItem>>{
        return liveDataList
    }

    fun makeAPICall(){
        val serviceInstance=APIService.getData()
        val apiService=serviceInstance.create(API::class.java)
        val call=apiService.getCountryList()
        call.enqueue(object :Callback<List<CountryModelItem>>{
            override fun onResponse(
                call: Call<List<CountryModelItem>>,
                response: Response<List<CountryModelItem>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryModelItem>>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}