package org.sushobh.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.Dagger.Components.DaggerActivityBuilder
import org.sushobh.exampleapp.Dagger.Modules.ViewModelModule
import org.sushobh.exampleapp.ViewModels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {


    override fun inject() {
        DaggerActivityBuilder.builder().viewModelModule(ViewModelModule(this))
            .build().inject(this)
    }


    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.toString()
    }


}
