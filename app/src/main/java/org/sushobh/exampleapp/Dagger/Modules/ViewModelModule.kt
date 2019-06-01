package org.sushobh.exampleapp.Dagger.Modules

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.ViewModels.MainViewModel


@Module
class ViewModelModule(var baseActivity: BaseActivity) {


    @Provides
    fun provideMainViewModel (): MainViewModel {
        return ViewModelProviders.of(baseActivity).get(MainViewModel::class.java)
    }



}