package org.sushobh.exampleapp.Base

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

open class BasePresenter<T : BaseActivity> : DatePickerDialog.OnDateSetListener {




    var activity : T? = null
    var viewModel : BaseViewModel<out BasePresenter<T>>? = null
    var  datePickerDialog : DatePickerDialog?


    constructor(activity : T,viewModel : BaseViewModel<out BasePresenter<T>>?){
        this.activity = activity
        this.viewModel = viewModel
        datePickerDialog = DatePickerDialog(activity,this,Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
    }


    fun showDatePicker(){
         datePickerDialog?.show()
    }

    fun hideDatePicker(){
        datePickerDialog?.hide()
    }


    fun toast(message : String){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        viewModel?.onDateSetFromDatePicker(p1,p2,p3)
    }




}