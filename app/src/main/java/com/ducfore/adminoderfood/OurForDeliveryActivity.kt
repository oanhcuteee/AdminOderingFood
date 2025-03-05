package com.ducfore.adminoderfood

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ducfore.adminoderfood.Adapter.DeliveryAdapter
import com.ducfore.adminoderfood.databinding.ActivityOurForDeliveryBinding

class OurForDeliveryActivity : AppCompatActivity() {
    private val binding:ActivityOurForDeliveryBinding by lazy {
        ActivityOurForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val menuCustomerName = arrayListOf("Duc","Ngoc","Long")
        val menuMoneyStatus = arrayListOf("not received","received","pending")
         val adapter = DeliveryAdapter(ArrayList(menuCustomerName),ArrayList(menuMoneyStatus))
        binding.outForDeliveryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.outForDeliveryRecyclerView.adapter = adapter

        binding.backOutForDeliveryBtn.setOnClickListener {
            finish()
        }

    }
}