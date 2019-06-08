package org.sushobh.exampleapp.ui.main

import android.content.Intent
import org.sushobh.exampleapp.AddTaskActivity
import org.sushobh.exampleapp.Base.BasePresenter
import org.sushobh.exampleapp.MainActivity
import org.sushobh.exampleapp.ui.addtask.AddTaskViewModel

class MainPresenter : BasePresenter<MainActivity,MainViewModel> {


    fun startNewTaskActivity() {
        activity?.startActivity(Intent(activity,AddTaskActivity::class.java))
    }


    constructor(mainActivity: MainActivity, mainViewModel: MainViewModel) :
            super(mainActivity,mainViewModel) {
    }






}