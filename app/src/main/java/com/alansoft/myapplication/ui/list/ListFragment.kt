package com.alansoft.myapplication.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.viewModels
import com.alansoft.myapplication.R
import com.alansoft.myapplication.data.RemoteResult
import com.alansoft.myapplication.databinding.FragmentListBinding
import com.alansoft.myapplication.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by LEE MIN KYU on 2021/04/30
 * Copyright © 2021 Dreamus Company. All rights reserved.
 */
@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>() {
    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by viewModels()
    private val adapter: RepoListAdapter = RepoListAdapter()

    override fun getLayoutId(): Int = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter()
        setSubscribe()
    }

    private fun setSubscribe() {
        viewModel.results.observe(viewLifecycleOwner) {
            when (it) {
                is RemoteResult.Loading -> {
                }
                is RemoteResult.Success -> {
                    setResultData(it.data)
                }
                is RemoteResult.Error -> {
                    Toast.makeText(this.context, it.exception.message, LENGTH_SHORT).show()
                }
                else -> {
                    // nothing
                }
            }
        })

    }

    private fun setRecyclerAdapter() {
        binding.recyclerView.run {
            setHasFixedSize(true)
            clearOnScrollListeners()
            adapter = this.adapter
        }
    }

    private fun setResultData(data: BooksSearchResponse) {
        val list: MutableList<Document?> = ArrayList()
        if (data.meta?.page ?: -1 > 1) {
            list.addAll(adapter.currentList)
        }
        data.documents?.let {
            list.addAll(it)
        }
        adapter.submitList(list)
    }

}