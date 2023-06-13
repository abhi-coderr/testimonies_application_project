package com.yogeshwar.testimoniesapp.presentation.di

import com.yogeshwar.testimoniesapp.data.repository.testimony.TestimonyRepositoryImpl
import com.yogeshwar.testimoniesapp.data.repository.testimony.datasource.TestimonyRemoteDataSource
import com.yogeshwar.testimoniesapp.domain.repository.TestimonyRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryDataModule {

    @Provides
    @Reusable
    fun provideTestimonyRepository(remoteDataSource: TestimonyRemoteDataSource): TestimonyRepository {
        return TestimonyRepositoryImpl(remoteDataSource)
    }


}