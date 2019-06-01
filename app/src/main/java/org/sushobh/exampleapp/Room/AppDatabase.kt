package org.sushobh.exampleapp.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sushobh.exampleapp.Room.Entity.User


@Database(entities = arrayOf(User::class) , version =  1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}