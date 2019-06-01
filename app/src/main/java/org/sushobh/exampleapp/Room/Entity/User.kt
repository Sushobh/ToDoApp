package org.sushobh.exampleapp.Room.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
 class User(  var name : String,
              var city : String,
             var age : Int = 0){

     @PrimaryKey(autoGenerate = true)
     var id : Int = 0

}

