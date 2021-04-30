package com.alansoft.myapplication.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alansoft.myapplication.data.RemoteResult
import com.alansoft.myapplication.data.model.IssueResponse
import com.alansoft.myapplication.repository.RepoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
class ListViewModel @Inject constructor(
    private val repository: RepoRepository
) : ViewModel() {

    private val request = MutableStateFlow(Pair("", ""))

    val _results: MutableLiveData<RemoteResult<IssueResponse>> = request
        .flatMapLatest {
            repository.getIssues(it.first, it.second)
        }
        .asLiveData() as MutableLiveData
    val results: LiveData<RemoteResult<IssueResponse>> = _results

    fun setRequest(
        githubUsername: String,
        repositoryName: String
    ) {
        request.value = githubUsername to repositoryName
    }
}