package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.setText(intent.getStringExtra("DATA_REC"))
    }
}