package com.bimabagaskhoro.assigment2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.assigment2.R
import com.bimabagaskhoro.assigment2.databinding.ItemsEventBinding
import com.bimabagaskhoro.assigment2.domain.model.ItemEvent
import com.bumptech.glide.Glide
import java.util.ArrayList

class EventAdapter : RecyclerView.Adapter<EventAdapter.ListViewHolder>() {
    private var listData = ArrayList<ItemEvent>()
    var onItemClick: ((ItemEvent) -> Unit)? = null

    fun setData(newListData: List<ItemEvent>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_event, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsEventBinding.bind(itemView)
        fun bind(data: ItemEvent) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgEvent)
                tvTittle.text = data.name
                tvDate.text = data.date
                itemView.setOnClickListener {
                    onItemClick?.invoke(data)
                }
            }
        }
    }

}