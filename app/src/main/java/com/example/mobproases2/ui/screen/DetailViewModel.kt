package com.example.mobproases2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobproases2.database.BungaDao
import com.example.mobproases2.model.Bunga
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: BungaDao) : ViewModel() {

    fun insert(nama: String, harga: String, stok: String) {
        val bunga = Bunga(
            nama = nama,
            harga = harga,
            stok = stok
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(bunga)
        }
    }

    suspend fun getBunga(id: Long): Bunga? {
        return dao.getBungaById(id)
    }

    fun update(id: Long, nama: String, harga: String, stok: String) {
        val bunga = Bunga(
            id = id,
            nama = nama,
            harga =  harga,
            stok = stok
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(bunga)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deletedById(id)
        }
    }
}