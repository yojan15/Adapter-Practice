package com.example.adapter.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.adapter.R
import com.example.adapter.adapter.ViewAdapter
import com.example.adapter.databinding.ActivityMainBinding
import com.example.adapter.model.ServerModel
import com.example.adapter.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : ViewAdapter
    private lateinit var viewModel : MainViewModel
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
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        adapter = ViewAdapter(serverModel = emptyList())
        binding.recyclerViewServers.adapter = adapter

        viewModel.serverModelList.observe(this) {response->
            viewModel.list.clear()
            viewModel.list.addAll(response)

            adapter.updateList(viewModel.list)

        }
    }
}