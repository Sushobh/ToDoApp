package org.sushobh.exampleapp.ui.addtask

import android.widget.EditText
import kotlinx.android.synthetic.main.add_task_fragment.view.*
import org.sushobh.exampleapp.AddTaskActivity
import org.sushobh.exampleapp.Base.BasePresenter
import org.sushobh.exampleapp.R

class AddTaskPresenter : BasePresenter<AddTaskActivity> {


    lateinit var addTaskViewModel: AddTaskViewModel
     var etDate : EditText? = null

    constructor(addTaskActivity: AddTaskActivity,addTaskViewModel: AddTaskViewModel) :
            super(addTaskActivity,addTaskViewModel) {
        this.addTaskViewModel = addTaskViewModel
    }

    fun setDateText(dateText : String){
        if(etDate == null){
            etDate = activity?.findViewById(R.id.select_date_picker)
        }
        etDate?.setText(dateText)

    }

}