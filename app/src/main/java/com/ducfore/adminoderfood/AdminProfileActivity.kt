package com.ducfore.adminoderfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ducfore.adminoderfood.databinding.ActivityAdminProfileBinding

class AdminProfileActivity : AppCompatActivity() {
    private val binding:ActivityAdminProfileBinding by lazy{
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.backAdminProfile.setOnClickListener {
            finish()
        }
       binding.name.isEnabled = false
       binding.address.isEnabled = false
       binding.email.isEnabled = false
       binding.phone.isEnabled = false
       binding.password.isEnabled = false

       var isEnable = false
        binding.editButton.setOnClickListener {
            isEnable = ! isEnable

            binding.name.isEnabled = true
            binding.address.isEnabled = true
            binding.email.isEnabled = true
            binding.phone.isEnabled = true
            binding.password.isEnabled = true
            if(isEnable){
                binding.name.requestFocus()
            }
        }

    }
}