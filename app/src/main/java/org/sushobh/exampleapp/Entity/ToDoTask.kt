package org.sushobh.exampleapp.Entity

import org.sushobh.exampleapp.Base.Util

data class ToDoTask( val name : String = "",
                     val addedOn : String= "",
                     val addedBy : String= "",
                     val shouldBeReminded : Boolean = false,
                     val scheduledFor : String= "",
                     var  completed : Boolean = false,
                     var taskDateToDislplay : String?= "",
                     var statusToDisplay : String? = "",
                     var id : String? = "NULL",
                     var timeStamp : String = Util.getCurrentTimeStamp()
)
{
    constructor() : this("")
}