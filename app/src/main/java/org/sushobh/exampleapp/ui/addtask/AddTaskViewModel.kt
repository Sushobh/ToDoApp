package org.sushobh.exampleapp.ui.addtask

import androidx.lifecycle.ViewModel
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.Base.BaseViewModel
import org.sushobh.exampleapp.Dagger.Components.DaggerViewModelBuilder
import org.sushobh.exampleapp.Dagger.Modules.ModelsModule
import org.sushobh.exampleapp.Entity.ToDoTask

class AddTaskViewModel : BaseViewModel<AddTaskPresenter>() {


    var currentTaskNameInput : String = ""
    var currentDateInput : String = ""

    init {
        DaggerViewModelBuilder.builder().modelsModule(ModelsModule()).build().inject(this);
    }

    fun clickedOnSelectDate() {
        presenter?.showDatePicker()
    }

    override fun  onDateSetFromDatePicker(year: Int, month: Int, dayOfMonth: Int) {
        currentDateInput = ""+year+"-"+(month+1)+"-"+dayOfMonth
    }

    fun taskNameTextChanged(taskName: String) {
        currentTaskNameInput = taskName
    }

    fun clickedOnAddTask() {
        if(currentDateInput.isEmpty() || currentTaskNameInput.isEmpty()){
            presenter?.toast("Please add task name and select date")
        }
        else {
             taskModel.addTask(ToDoTask(currentTaskNameInput,currentDateInput,userModel.getLoggedInUser().id,
                 true,"null")).addOnFailureListener {
                 presenter?.toast("Failed to save task!")
             }.addOnSuccessListener {
                 presenter?.toast("Task Saved!")
             }
        }
    }


}
