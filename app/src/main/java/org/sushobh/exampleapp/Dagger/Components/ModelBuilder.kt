package org.sushobh.exampleapp.Dagger.Components

import dagger.Component
import org.sushobh.exampleapp.Base.BaseModel
import org.sushobh.exampleapp.Dagger.Modules.FireBaseModule
import org.sushobh.exampleapp.Dagger.Modules.RetrofitModule
import org.sushobh.exampleapp.Dagger.Modules.RoomDatabaseModule
import javax.inject.Singleton


@Singleton
@Component(modules = [RetrofitModule::class,RoomDatabaseModule::class,FireBaseModule::class])
interface ModelBuilder {
    fun inject (baseModel: BaseModel)
}