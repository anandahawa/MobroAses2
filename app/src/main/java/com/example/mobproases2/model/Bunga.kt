package com.example.mobproases2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bunga")
data class Bunga(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val harga: String,
    val stok: String
)