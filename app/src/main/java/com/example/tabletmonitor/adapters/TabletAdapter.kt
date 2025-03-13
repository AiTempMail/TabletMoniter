package com.example.tabletmonitor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tabletmonitor.databinding.ItemTabletBinding
import com.example.tabletmonitor.database.Tablet

class TabletAdapter(private val onClick: (Tablet) -> Unit) :
    ListAdapter<Tablet, TabletAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(private val binding: ItemTabletBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tablet: Tablet) {
            with(binding) {
                tvName.text = tablet.name
                tvDosage.text = tablet.dosage
                tvStock.text = "Stock: ${tablet.stock}"
                root.setOnClickListener { onClick(tablet) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTabletBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<Tablet>() {
        override fun areItemsTheSame(oldItem: Tablet, newItem: Tablet) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Tablet, newItem: Tablet) =
            oldItem == newItem
    }
}