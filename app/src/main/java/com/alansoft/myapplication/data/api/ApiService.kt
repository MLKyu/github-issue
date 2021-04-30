package com.alansoft.myapplication.data.api

import com.alansoft.myapplication.data.model.IssueResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
interface ApiService {
    @GET("/repos/{github_username}/{repository_name}/issues")
    suspend fun getIssues(
        @Path("github_username") github_username: String,
        @Path("repository_name") repository_name: String,
    ): IssueResponse
}