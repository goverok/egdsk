package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.App
import com.example.myapplication.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): AppComponent
    }
}

interface AppComponentHolder {
    val component: AppComponent
    fun createAppComponent(
        applicationContext: Context,
    ): AppComponent = DaggerAppComponent.factory().create(
        context = applicationContext,
    )
}
