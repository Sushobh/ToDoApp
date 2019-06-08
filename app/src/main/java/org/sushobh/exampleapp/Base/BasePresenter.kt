package org.sushobh.exampleapp.Base

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.widget.DatePicker
import android.widget.Toast
import org.sushobh.exampleapp.R
import java.util.*

open class BasePresenter<T : BaseActivity,V : BaseViewModel<*>> : DatePickerDialog.OnDateSetListener {




    var activity : T? = null
    var viewModel : V? = null
    var  datePickerDialog : DatePickerDialog?
    lateinit var  progressDialog : ProgressDialog


    constructor(activity : T,viewModel : V?){
        this.activity = activity
        this.viewModel = viewModel
        datePickerDialog = DatePickerDialog(activity,R.style.DatePickerDialogTheme,this,Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        initProgressDialog()
    }

    fun initProgressDialog(){
        progressDialog = ProgressDialog(activity)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
    }

    fun showProgressDialog(message: String = "Please wait"){
        if(!progressDialog.isShowing){
            progressDialog.setMessage(message)
            progressDialog.show()
        }
    }

    fun hideProgressDialog(){
        if(progressDialog.isShowing) {
            progressDialog.hide()
        }
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

    fun finishCurrentActivity(){
        activity?.finish()
    }
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        viewModel?.onDateSetFromDatePicker(p1,p2,p3)
    }

    fun setTitle(title : String){
        activity?.supportActionBar?.title = title
    }



}