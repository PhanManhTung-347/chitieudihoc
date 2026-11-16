package com.example.ktgk_phanmanhtung_2415053122347

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_phanmanhtung_2415053122347.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding_2347: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding_2347 = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.title = "Phan Manh Tung - 2415053122347"
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}