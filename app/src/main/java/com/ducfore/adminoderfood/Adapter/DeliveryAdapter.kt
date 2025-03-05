package com.ducfore.adminoderfood.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.adminoderfood.databinding.DeliveryItemBinding

class DeliveryAdapter(
    private val customersNames: ArrayList<String>,
    private val moneyStatus: ArrayList<String>

) : RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryAdapter.DeliveryViewHolder {
        val binding = DeliveryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeliveryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryAdapter.DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return customersNames.size
    }

    inner class DeliveryViewHolder(private val binding: DeliveryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.customerName.text = customersNames[position]
            binding.deliveryStatus.text = moneyStatus[position]

            val colorMap = mapOf("received" to Color.GREEN,"not received" to Color.RED,"pending" to Color.BLACK)
            binding.deliveryStatus.setTextColor(colorMap[moneyStatus[position]]?:Color.BLACK)
            binding.statusColor.backgroundTintList = ColorStateList.valueOf(colorMap[moneyStatus[position]]?:Color.BLACK)
        }

    }

}