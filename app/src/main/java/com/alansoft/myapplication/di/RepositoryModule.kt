package com.alansoft.myapplication.di

import com.alansoft.myapplication.data.RepoDataSource
import com.alansoft.myapplication.data.api.ApiService
import com.alansoft.myapplication.repository.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepoDataSource(apiService: ApiService) =
        RepoDataSource(apiService)

    @Singleton
    @Provides
    fun provideRepoRepository(
        remote: RepoDataSource
    ) =
        RepoRepository(remote)
}