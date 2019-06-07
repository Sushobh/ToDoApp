package org.sushobh.exampleapp.ui.addtask

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import org.sushobh.exampleapp.AddTaskActivity
import org.sushobh.exampleapp.R

class AddTaskFragment : Fragment() {

    companion object {
        fun newInstance() = AddTaskFragment()
    }



    @BindView(R.id.select_date_picker)
    lateinit var  selectDatePicker : EditText

    @BindView(R.id.task_name)
    lateinit var  etTaskName : EditText


    @BindView(R.id.button_add_task)
    lateinit var btAddTask : Button

    private lateinit var viewModel: AddTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView =  inflater.inflate(R.layout.add_task_fragment, container, false)

        ButterKnife.bind(this,rootView)

        selectDatePicker.setOnClickListener({
             viewModel.clickedOnSelectDate()
        })

        etTaskName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                viewModel.taskNameTextChanged(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

        btAddTask.setOnClickListener({
            viewModel.clickedOnAddTask()
        })

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddTaskViewModel::class.java)
        viewModel.presenter = AddTaskPresenter(activity as AddTaskActivity,viewModel)
        // TODO: Use the ViewModel
    }

}
