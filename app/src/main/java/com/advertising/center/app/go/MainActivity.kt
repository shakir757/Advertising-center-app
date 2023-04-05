package com.advertising.center.app.go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.advertising.center.app.go.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.textViewJ.text = "fggrehhs"
    }
}