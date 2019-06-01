package org.sushobh.exampleapp.Dagger.Components

import dagger.Component
import org.sushobh.exampleapp.Dagger.Modules.ViewModelModule
import org.sushobh.exampleapp.MainActivity
import javax.inject.Singleton


@Component(modules = [ViewModelModule::class])
@Singleton
interface ActivityBuilder {
    fun inject (mainActivity: MainActivity)
}