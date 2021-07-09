package com.example.mindteck

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mindteck.databinding.GridListRowBinding
import com.example.mindteck.model.DataModel
import java.util.ArrayList

class ListAdapter :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var dataModel: ArrayList<DataModel> = ArrayList()

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
        val list = dataModel[position]
        holder.binding.setVariable(BR.name, list.name)
        holder.binding.ivStatus.setImageBitmap(list.images)
        holder.binding.executePendingBindings()
    }


    override fun getItemCount(): Int {
        return dataModel.size
    }

    fun setData(model: List<DataModel>) {
        this.dataModel = model as ArrayList<DataModel>
        notifyDataSetChanged()
    }

    fun search(text: String) {
        val searchList = dataModel.filter {
            it.name.contains(text, ignoreCase = true)
        }
        dataModel = searchList as ArrayList<DataModel>
        notifyDataSetChanged()
    }

    fun clear() {
        this.dataModel.clear()
        notifyDataSetChanged()
    }
}