package org.sushobh.exampleapp.Entity

data class ToDoTask( val name : String = "",
                     val addedOn : String= "",
                     val addedBy : String= "",
                     val shouldBeReminded : Boolean = false,
                     val scheduledFor : String= "",
                     var  completed : Boolean = false,
                     var taskDateToDislplay : String?= "",
                     var statusToDisplay : String? = "",
                     var id : String? = "NULL"
)
{


    constructor() : this("")
}