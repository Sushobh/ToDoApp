package org.sushobh.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.ui.addtask.AddTaskFragment

class AddTaskActivity : BaseActivity() {
    override fun inject() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_task_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddTaskFragment.newInstance())
                .commitNow()
        }
    }

}
