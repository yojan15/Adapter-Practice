package com.example.adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.R
import com.example.adapter.model.ServerModel

class ViewAdapter(private val serverModel : ArrayList<ServerModel>) : RecyclerView.Adapter<ViewAdapter.ServerViewHolder>() {

    inner class ServerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tvName)
        var tvValue : TextView = itemView.findViewById(R.id.tvValue)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewAdapter.ServerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout,parent,false)
        return ServerViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewAdapter.ServerViewHolder, position: Int) {
        val server = serverModel[position]
        holder.tvName.text = server.name
        holder.tvValue.text = server.value
    }

    override fun getItemCount(): Int = serverModel.size
}