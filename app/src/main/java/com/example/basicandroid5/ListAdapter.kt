package com.example.basicandroid5

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicandroid5.databinding.UserItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private lateinit var binding : UserItemBinding
    private lateinit var context: Context
    companion object {
        var UserList : MutableList<User> = mutableListOf()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = UserItemBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bind(UserList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : User) {
            binding.apply {
                name.text = item.name
                age.text = item.age.toString()
                gender.text = item.gender
            }
        }
    }

}