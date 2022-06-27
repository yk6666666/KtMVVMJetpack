package com.dream.xiaobei.repository

import rxhttp.wrapper.param.RxHttp

/**
 *    author : yk
 *    date   : 2022/6/24 0024上午 10:06
 *    desc   :
 */
class MainViewRepository {
    suspend fun ApplyReasonRecord(
        orderId: Int
    ): String = ""
//        RxHttp.postJson("/rest/v2/usercenter/afterSale/list")
//            .addQuery("orderId", orderId)
//            .toResponse<String>()
//            .await()
}