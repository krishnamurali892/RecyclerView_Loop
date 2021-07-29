package com.example.networklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networklist.R
import com.example.networklist.databinding.RowItemBinding
import com.example.networklist.model.User


class UserAdapter(val userList : List<User>) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: RowItemBinding = RowItemBinding.inflate(LayoutInflater.from
            (parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binds(userList?.get(position)!!)
    }

    override fun getItemCount(): Int = if (userList?.size!! > 0) userList?.size!! else 0
}

class UserViewHolder(private val itemBinding: RowItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun binds(user : User){
        itemBinding.itemTitle.text = user.firstName
        Glide.with(itemBinding.itemImage.context).load(user.image).placeholder(R.drawable.ic_launcher_background)
            .into(itemBinding.itemImage)
    }
}