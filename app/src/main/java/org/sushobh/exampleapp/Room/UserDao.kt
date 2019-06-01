package org.sushobh.exampleapp.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.sushobh.exampleapp.Room.Entity.User


@Dao
interface UserDao {

    @Insert
    fun insert(user : User)

    @Query("select *from User")
    fun getAll() : List<User>
}