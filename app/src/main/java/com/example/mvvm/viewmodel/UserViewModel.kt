package com.example.mvvm.viewmodel

import android.app.Application
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.getUserItem
import com.example.mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val app: Application): AndroidViewModel(app) {
    private val _user = MutableLiveData<List<getUserItem>>()
    val user: LiveData<List<getUserItem>> = _user

    //var liveDataUser = MutableLiveData<List<getUserItem>>()

    fun getLiveDataUser():MutableLiveData<List<getUserItem>>{
        return _user
    }

        fun getAllUser(){
            ApiClient.instance.getUser()
                .enqueue(object : Callback<List<getUserItem>> {
                    override fun onResponse(
                        call: Call<List<getUserItem>>,
                        response: Response<List<getUserItem>>
                    ) {
                        if(response.isSuccessful) _user.postValue(response.body())
                    }

                    override fun onFailure(call: Call<List<getUserItem>>, t: Throwable) {
                        Toast.makeText(app, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
