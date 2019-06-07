package org.sushobh.exampleapp.Entity

data class ToDoTask( val name : String,
 val addedOn : String,
                    val addedBy : String,
                    val shouldBeReminded : Boolean,
                    val scheduledFor : String
)