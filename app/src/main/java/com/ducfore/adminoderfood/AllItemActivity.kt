package com.ducfore.adminoderfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.adminoderfood.Adapter.AddItemAdapter
import com.ducfore.adminoderfood.databinding.ActivityAddItemBinding
import com.ducfore.adminoderfood.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val menuFoodItem = listOf("Burger", "Spacy", "King", "Queen", "Sung")
        val menuPriceItem = listOf("15$", "12$", "7$", "17$", "21$")
        val menuImageItem = listOf(
            R.drawable.item1,
            R.drawable.item2,
            R.drawable.item3,
            R.drawable.item2,
            R.drawable.item1
        )
        val adapter = AddItemAdapter(
            ArrayList(menuFoodItem),
            ArrayList(menuPriceItem),
            ArrayList(menuImageItem)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecyclerView.adapter = adapter
        binding.backBtnAllItem.setOnClickListener {
            finish()
        }
    }

}