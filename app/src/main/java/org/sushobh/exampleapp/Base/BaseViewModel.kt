package org.sushobh.exampleapp.Base

import androidx.lifecycle.ViewModel
import org.sushobh.exampleapp.Dagger.Components.DaggerViewModelBuilder
import org.sushobh.exampleapp.Dagger.Modules.ModelsModule
import org.sushobh.exampleapp.Models.TaskModel
import org.sushobh.exampleapp.Models.UserModel
import javax.inject.Inject

abstract class BaseViewModel<T : BasePresenter<out BaseActivity>> : ViewModel {



    open fun onDateSetFromDatePicker(year: Int, month: Int, dayOfMonth: Int) {

    }


    @Inject
    lateinit var userModel : UserModel;

    @Inject
    lateinit var taskModel : TaskModel;

    var presenter : T? = null;

    constructor(){

    }

}