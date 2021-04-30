package com.alansoft.myapplication.ui.list

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import com.alansoft.myapplication.R
import com.alansoft.myapplication.data.model.IssueResponse
import com.alansoft.myapplication.ui.base.BaseListAdapter

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
class RepoListAdapter() : BaseListAdapter<IssueResponse>(DiffCallback()) {
    override fun createView(viewType: Int): Int {
        return R.layout.books_item
    }

    override fun getViewType(item: Document): Int {
        return R.layout.books_item.hashCode()
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        if (binding is Item) {
            binding.setVariable(BR.item, getItem(position))
        } else if(binding)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<IssueResponse>() {

    override fun areItemsTheSame(oldItem: IssueResponse, newItem: IssueResponse): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: IssueResponse, newItem: IssueResponse): Boolean {
        return oldItem == newItem
    }
}
