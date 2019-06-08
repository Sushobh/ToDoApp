package org.sushobh.exampleapp.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.sushobh.exampleapp.AddTaskActivity
import org.sushobh.exampleapp.Base.BaseFragment
import org.sushobh.exampleapp.MainActivity
import org.sushobh.exampleapp.R
import org.sushobh.exampleapp.ui.addtask.AddTaskPresenter

class MainFragment : BaseFragment<MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }


    @BindView(R.id.new_task)
    lateinit var btNewTask : FloatingActionButton



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var rootView =  inflater.inflate(R.layout.main_fragment, container, false)

        ButterKnife.bind(this,rootView)

        btNewTask.setOnClickListener(
            {
                viewModel.clickedOnAddNewTask()
            }
        )
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.presenter = MainPresenter(activity as MainActivity,viewModel)
        viewModel.init()
    }





}
