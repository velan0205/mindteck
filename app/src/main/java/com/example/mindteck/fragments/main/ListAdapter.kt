package com.example.mindteck.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mindteck.R
import com.example.mindteck.databinding.GridListRowBinding
import com.example.mindteck.model.Heroes

class ListAdapter :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var list: List<Heroes> = emptyList()

    inner class ViewHolder(val binding: GridListRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: GridListRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.grid_list_row,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = list[position]

      //  holder.binding.setVariable(BR.name, list.name.toString())
      //  Glide.with(this).load(R.drawable.).into(myImageView);

      //  holder.binding.setVariable(BR.resource, resId)
        holder.binding.executePendingBindings()
    }


    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: List<Heroes>) {
        this.list = list
        notifyDataSetChanged()
    }
}