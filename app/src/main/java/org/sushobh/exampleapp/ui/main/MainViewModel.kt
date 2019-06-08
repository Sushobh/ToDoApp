package org.sushobh.exampleapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import org.sushobh.exampleapp.Base.BaseViewModel
import org.sushobh.exampleapp.Base.Constants
import org.sushobh.exampleapp.Base.Util
import org.sushobh.exampleapp.Dagger.Components.DaggerViewModelBuilder
import org.sushobh.exampleapp.Dagger.Modules.ModelsModule
import org.sushobh.exampleapp.Entity.ToDoTask
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : BaseViewModel<MainPresenter>() {

    var tasks : ArrayList<ToDoTask> = ArrayList<ToDoTask>()
    var taskLiveData =  MutableLiveData<List<ToDoTask>>()


    init {
        DaggerViewModelBuilder.builder().modelsModule(ModelsModule()).build().inject(this);
    }

    override fun init() {
        super.init()
        presenter?.setTitle("ToDoApp")
        taskModel.getTasks(userModel.getLoggedInUser().id)
            .addSnapshotListener(object :  com.google.firebase.firestore.EventListener<QuerySnapshot> {
                override fun onEvent(snapshot: QuerySnapshot?, p1: FirebaseFirestoreException?) {
                    tasks.clear()
                    snapshot?.documents?.forEach({

                            var toDoTask =  it.toObject(ToDoTask::class.java)

                            if (toDoTask != null) {
                                toDoTask?.id = it.id
                                if(toDoTask.completed == true){
                                    toDoTask.statusToDisplay = "Completed"
                                }
                                else
                                {
                                    toDoTask.statusToDisplay = "Pending"
                                }
                                toDoTask.taskDateToDislplay = Util.convertDateStringToFormat(toDoTask.addedOn,
                                    Constants.TASK_DATE_FORMAT,Constants.TASK_DATE_FORMAT_DISPLAY)
                                tasks.add(toDoTask)
                            }
                    })
                    taskLiveData.value = tasks
                }
            })
    }


    fun clickedOnAddNewTask() {
        presenter?.startNewTaskActivity()
    }

    fun clickedOnTask(adapterPosition: Int) {
         var task =  tasks[adapterPosition].copy()
         task.completed = !task.completed
         taskModel.updateTask(task)
    }

}
