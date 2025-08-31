package com.example.adapter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adapter.model.ServerModel
import kotlin.collections.arrayListOf

class MainViewModel : ViewModel() {
    val serverModelList : MutableLiveData<List<ServerModel>> = MutableLiveData()

    var list = ArrayList<ServerModel>()
    val selectedItem = ServerModel()

    init {
        loadList()
    }

    private fun loadList() {
        serverModelList.value = arrayListOf(
        ServerModel(1,"server one","192.168.1.1"),
        ServerModel(2,"server two","192.168.1.2"),
        ServerModel(3,"server three","192.168.1.3"),
        ServerModel(4,"server four","192.168.1.4"),
        ServerModel(5,"server five","192.168.1.5"),
        ServerModel(6,"server six","192.168.1.6"),
        )}
}