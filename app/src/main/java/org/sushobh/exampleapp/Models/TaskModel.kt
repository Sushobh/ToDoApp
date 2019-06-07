package org.sushobh.exampleapp.Models


import com.google.android.gms.tasks.Task
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


}