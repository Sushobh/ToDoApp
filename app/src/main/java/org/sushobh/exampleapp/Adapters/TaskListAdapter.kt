package org.sushobh.exampleapp.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
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
       return tasks.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var task = tasks[position]

        holder.tvTaskDate.text = task.taskDateToDislplay
        holder.tvTaskStatus.text = task.statusToDisplay
        holder.tvTaskName.text = task.name

        if(task.completed == false){
            holder.divider.setBackgroundColor(Color.RED)
            holder.tvTaskName.setTextColor(Color.RED)
        }
        else
        {
            holder.divider.setBackgroundColor(ContextCompat.getColor(holder.divider.context,R.color.colorPrimary))
            holder.tvTaskName.setTextColor(ContextCompat.getColor(holder.divider.context,R.color.colorPrimary))
        }
    }


    inner class MyViewHolder: RecyclerView.ViewHolder {


            @BindView(R.id.task_name)
            lateinit var tvTaskName : TextView


            @BindView(R.id.task_date)
            lateinit var tvTaskDate : TextView


            @BindView(R.id.task_status)
            lateinit var tvTaskStatus : TextView

            @BindView(R.id.divider)
            lateinit var divider : View




            constructor(itemView: View) : super(itemView){
               ButterKnife.bind(this,itemView)
                itemView.setOnClickListener({
                    mainViewModel.clickedOnTask(adapterPosition)
                })
            }
        }

}
