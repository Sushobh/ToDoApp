package org.sushobh.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.ui.main.MainFragment

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun inject() {

    }

}
