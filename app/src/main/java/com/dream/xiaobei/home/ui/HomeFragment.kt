package com.dream.xiaobei.home.ui

import android.os.Bundle
import com.blankj.utilcode.util.BarUtils
import com.dream.xiaobei.databinding.FragmentHomeBinding
import com.dream.xiaobei.home.vm.AreaViewModel
import com.tcl.base.common.ui.BaseFragment

/**
 *@author yk
 *@date   2022/1/26
 *description 首页
 */
class HomeFragment : BaseFragment<AreaViewModel, FragmentHomeBinding> (){

    private val columnsTitle = arrayOf("推荐","新人","女神","附近")
    override fun initView(savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(mBinding.homeTitleBar)
        
    }
}