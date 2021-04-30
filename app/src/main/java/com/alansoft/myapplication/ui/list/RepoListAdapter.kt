package com.alansoft.myapplication.ui.list

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import com.alansoft.myapplication.R
import com.alansoft.myapplication.data.model.Issue
import com.alansoft.myapplication.data.model.IssueResponse
import com.alansoft.myapplication.ui.base.BaseListAdapter

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
class RepoListAdapter : BaseListAdapter<Issue>(DiffCallback()) {
    override fun createView(viewType: Int): Int {
        return R.layout.item_list
    }

    override fun getViewType(item: Issue): Int {
        return R.layout.item_list.hashCode()
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        if (binding is ItemList) {
            binding.setVariable(BR.item, getItem(position))
        } else if (binding)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Issue>() {

    override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean {
        return oldItem == newItem
    }
}
