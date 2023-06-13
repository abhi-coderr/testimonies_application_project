package com.yogeshwar.testimoniesapp.presentation.di

import com.yogeshwar.testimoniesapp.domain.repository.TestimonyRepository
import com.yogeshwar.testimoniesapp.domain.usecase.GetTestimonyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseDataModule {

    @Provides
    fun provideGetTestimonyUseCase(
        repository: TestimonyRepository
    ): GetTestimonyUseCase {
        return GetTestimonyUseCase(repository)
    }

}