package com.yogeshwar.testimoniesapp.presentation.di

import com.yogeshwar.testimoniesapp.data.repository.testimony.datasource.TestimonyRemoteDataSource
import com.yogeshwar.testimoniesapp.data.repository.testimony.datasourceimpl.TestimonyRemoteDataSourceImpl
import com.yogeshwar.testimoniesapp.domain.handlers.FirebaseDataHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideTestimonyRemoteDataSource(firebaseDataHandler: FirebaseDataHandler)
            : TestimonyRemoteDataSource {
        return TestimonyRemoteDataSourceImpl(firebaseDataHandler)
    }

}