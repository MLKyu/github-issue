package com.alansoft.myapplication.data

import com.alansoft.myapplication.data.api.ApiService
import javax.inject.Inject

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
class RepoDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getIssues(
        githubUsername: String,
        repositoryName: String
    ) = apiService.getIssues(
        githubUsername, repositoryName
    )
}