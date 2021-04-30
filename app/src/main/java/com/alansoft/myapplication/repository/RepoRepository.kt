package com.alansoft.myapplication.repository

import com.alansoft.myapplication.data.RemoteResult
import com.alansoft.myapplication.data.RepoDataSource
import com.alansoft.myapplication.data.model.IssueResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import java.io.IOException
import javax.inject.Inject

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
class RepoRepository @Inject constructor(
    private val remote: RepoDataSource
) {
    fun getIssues(
        githubUsername: String,
        repositoryName: String
    ): Flow<RemoteResult<IssueResponse>> = flow {
        emit(RemoteResult.loading())

        val response: IssueResponse = remote.getIssues(githubUsername, repositoryName)

        emit(RemoteResult.success(response))
    }.retry(2) { cause ->
        cause is IOException
    }.catch { e ->
        emit(RemoteResult.error(e))
    }

}