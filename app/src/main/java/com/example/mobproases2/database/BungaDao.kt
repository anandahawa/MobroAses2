package com.example.mobproases2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mobproases2.model.Bunga
import kotlinx.coroutines.flow.Flow

@Dao
interface BungaDao {

    @Insert
    suspend fun insert(bunga: Bunga)

    @Update
    suspend fun update(bunga: Bunga)

    @Query("SELECT * FROM bunga ORDER BY nama ASC")
    fun getBunga(): Flow<List<Bunga>>

    @Query("SELECT * FROM bunga WHERE id = :id")
    suspend fun getBungaById(id: Long): Bunga?

    @Query("DELETE FROM bunga WHERE id = :id")
    suspend fun deletedById(id: Long)
}