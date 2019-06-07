package org.sushobh.exampleapp.Models

import org.sushobh.exampleapp.Base.BaseModel
import org.sushobh.exampleapp.Entity.User

class UserModel : BaseModel() {

    fun getLoggedInUser() : User{
        return User("1","Sushobh Nadiger");

    }

}