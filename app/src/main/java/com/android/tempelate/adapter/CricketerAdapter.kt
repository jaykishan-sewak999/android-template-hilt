package com.android.tempelate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.tempelate.databinding.CricketerRowItemBinding
import com.android.tempelate.model.User

class CricketerAdapter(private val cricketerList: List<User>):
    RecyclerView.Adapter<CricketerAdapter.CricketerViewHolder>() {
    class CricketerViewHolder(private val binding: CricketerRowItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User?) {
            binding.user = user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketerViewHolder {
        val binding = CricketerRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CricketerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CricketerViewHolder, position: Int) {
        holder.bind(cricketerList[position])
    }

    override fun getItemCount(): Int {
        return cricketerList.size
    }
}