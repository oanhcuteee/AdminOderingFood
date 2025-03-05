package com.ducfore.adminoderfood.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.adminoderfood.databinding.ItemAllitemBinding

class AddItemAdapter(
    private val menuNameItem: ArrayList<String>,
    private val menuPriceItem: ArrayList<String>,
    private val menuImageItem: ArrayList<Int>

) : RecyclerView.Adapter<AddItemAdapter.AllItemViewHolder>() {
    private val itemQuantities = IntArray(menuNameItem.size) { 1 }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        val binding = ItemAllitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuImageItem.size
    }

    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class AllItemViewHolder(private val binding: ItemAllitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val quantity = itemQuantities[position]
            binding.nameItem.text = menuNameItem[position]
            binding.priceItem.text = menuPriceItem[position]
            binding.imageItem.setImageResource(menuImageItem[position])
            binding.quantitiesTextView.text = quantity.toString()
            binding.minusBtn.setOnClickListener {
                decreaseQuantities(position)
            }
            binding.plushBtn.setOnClickListener {
                increaseQuantities(position)
            }
            binding.deletedBtn.setOnClickListener {
                deleteQuantities(position)
            }


        }

        private fun deleteQuantities(position: Int) {
            menuNameItem.removeAt(position)
            menuPriceItem.removeAt(position)
            menuImageItem.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,menuNameItem.size)
        }

        @SuppressLint("SetTextI18n")
        private fun increaseQuantities(position: Int) {
            if (itemQuantities[position]<15){
                itemQuantities[position]++
                binding.quantitiesTextView.text = itemQuantities[position].toString()
            }
        }

        @SuppressLint("SetTextI18n")
        private fun decreaseQuantities(position: Int) {
            if (itemQuantities[position]>1){
                itemQuantities[position]--
                binding.quantitiesTextView.text = itemQuantities[position].toString()
            }
        }

    }
}