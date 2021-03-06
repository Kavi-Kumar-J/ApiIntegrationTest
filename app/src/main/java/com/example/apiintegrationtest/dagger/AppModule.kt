package com.example.apiintegrationtest.dagger

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app : Application) {

    @Provides
   fun provideApplication(): Application {
       return app
   }

}