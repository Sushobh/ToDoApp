package org.sushobh.exampleapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import kotlinx.android.synthetic.main.item_task.view.*
import org.sushobh.exampleapp.Entity.ToDoTask
import org.sushobh.exampleapp.R
import org.sushobh.exampleapp.ui.main.MainViewModel

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.MyViewHolder> {

    lateinit var tasks : List<ToDoTask>
    lateinit var mainViewModel: MainViewModel

    constructor(tasks : List<ToDoTask>,mainViewModel: MainViewModel) : super(){
        this.tasks = tasks
        this.mainViewModel = mainViewModel
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))
    }

    override fun getItemCount(): Int {
       return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class MyViewHolder: RecyclerView.ViewHolder {


            @BindView(R.id.task_name)
            lateinit var tvTaskName : TextView


            @BindView(R.id.task_date)
            lateinit var tvTaskDate : TextView


            @BindView(R.id.task_status)
            lateinit var tvTaskStatus : TextView




            constructor(itemView: View) : super(itemView){
               ButterKnife.bind(this,itemView)
            }
        }

}
