package com.yogeshwar.testimoniesapp.presentation.di

import com.yogeshwar.testimoniesapp.data.handlers.FirebaseUtil
import com.yogeshwar.testimoniesapp.domain.handlers.FirebaseDataHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HandlerModule {

    @Provides
    @Singleton
    fun provideFirebaseDataHandler(): FirebaseDataHandler {
        return FirebaseUtil()
    }

}