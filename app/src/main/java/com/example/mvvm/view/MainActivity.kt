package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.model.getUserItem
import com.example.mvvm.network.ApiClient
import com.example.mvvm.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter : UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()

    }

    fun setViewModel(){
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getLiveDataUser().observe(this, Observer{
            userAdapter = UserAdapter(it)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvUser.layoutManager  = layoutManager
            binding.rvUser.adapter = userAdapter

        })
        viewModel.getAllUser()
    }


}