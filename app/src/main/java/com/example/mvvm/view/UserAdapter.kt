package com.example.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.UserItemBinding
import com.example.mvvm.model.getUserItem

class UserAdapter(var listUser : List<getUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(var binding : UserItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nama.text = listUser[position].name
        holder.binding.alamat.text= listUser[position].address
        holder.binding.umur.text = listUser[position].age.toString()
    }


}