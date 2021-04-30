package com.alansoft.myapplication.ui.list

import com.alansoft.myapplication.R
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

    override fun getLayoutId(): Int = R.layout.fragment_list
}