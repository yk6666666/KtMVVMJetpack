package com.dream.xiaobei.main

import androidx.lifecycle.MutableLiveData
import com.dream.xiaobei.repository.MainViewRepository
import com.tcl.base.common.BaseViewModel

/**
 *@author yk
 *@date   2021/12/8
 *description
 */
class MainViewModel : BaseViewModel() {
    private val mainViewRepository = MainViewRepository()
    val mainViewResult = MutableLiveData<String>()

    fun tvMainView(
        pageNo: Int
    ){
        rxLaunchUI({
            val result = mainViewRepository.ApplyReasonRecord(pageNo)
            result.let {
                mainViewResult.value = result
            }
        }, errorBlock = {
            it.printStackTrace()
        })
    }
}