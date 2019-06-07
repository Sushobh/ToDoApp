package org.sushobh.exampleapp.Dagger.Components

import dagger.Component
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.Base.BasePresenter
import org.sushobh.exampleapp.Base.BaseViewModel
import org.sushobh.exampleapp.Dagger.Modules.ModelsModule
import org.sushobh.exampleapp.Dagger.Modules.RetrofitModule
import org.sushobh.exampleapp.Dagger.Modules.RoomDatabaseModule
import org.sushobh.exampleapp.ui.addtask.AddTaskViewModel
import org.sushobh.exampleapp.ui.main.MainViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [ModelsModule::class])
interface ViewModelBuilder {

    fun inject(baseViewModel: AddTaskViewModel) ;
}