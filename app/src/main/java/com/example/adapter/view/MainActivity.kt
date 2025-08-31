package com.example.adapter.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adapter.R
import com.example.adapter.adapter.ViewAdapter
import com.example.adapter.databinding.ActivityMainBinding
import com.example.adapter.model.ServerModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : ViewAdapter
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val serverList = arrayListOf(
            ServerModel(1,"server one","192.168.1.1"),
            ServerModel(2,"server two","192.168.1.2"),
            ServerModel(3,"server three","192.168.1.3"),
            ServerModel(4,"server four","192.168.1.4"),
            ServerModel(5,"server five","192.168.1.5"),
            ServerModel(6,"server six","192.168.1.6"),
        )
        adapter = ViewAdapter(serverList)
        binding.recyclerViewServers.adapter = adapter
    }
}