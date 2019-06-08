package org.sushobh.exampleapp.Models


import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import org.sushobh.exampleapp.Base.BaseModel
import org.sushobh.exampleapp.Base.Constants.Companion.COLLECTION_TASKS
import org.sushobh.exampleapp.Base.Constants.Companion.COLLECTION_USERS
import org.sushobh.exampleapp.Entity.ToDoTask

class TaskModel : BaseModel() {
    fun addTask(task : ToDoTask) : Task<DocumentReference> {
     return  firebaseFirestore.collection(COLLECTION_USERS)
          .document(task.addedBy)
          .collection(COLLECTION_TASKS)
          .add(task)


    }

    fun getTasks (userId : String) : CollectionReference{
        return firebaseFirestore.collection(COLLECTION_USERS)
            .document(userId)
            .collection(COLLECTION_TASKS);
    }

    fun updateTask(task: ToDoTask) {
        var taskId = task.id;
        val data = HashMap<String, Any>()

        if (taskId != null) {
            data[taskId] = task
            firebaseFirestore.collection(COLLECTION_USERS)
                .document(task.addedBy)
                .collection(COLLECTION_TASKS)
                .document(taskId).set(task)
        }

    }


}