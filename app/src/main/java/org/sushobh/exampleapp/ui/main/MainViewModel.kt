package org.sushobh.exampleapp.ui.main

import androidx.lifecycle.ViewModel
import org.sushobh.exampleapp.Base.BaseViewModel

class MainViewModel : BaseViewModel<MainPresenter>() {


    override fun init() {
        super.init()
        presenter?.setTitle("ToDoApp")
    }

    fun clickedOnAddNewTask() {
        presenter?.startNewTaskActivity()
    }
}
