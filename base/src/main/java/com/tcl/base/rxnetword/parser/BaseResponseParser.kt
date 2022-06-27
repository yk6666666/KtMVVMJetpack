package com.tcl.base.rxnetword.parser

import rxhttp.wrapper.entity.ParameterizedTypeImpl
import rxhttp.wrapper.exception.ParseException
import rxhttp.wrapper.parse.AbstractParser
import rxhttp.wrapper.utils.convert
import java.io.IOException
import java.lang.reflect.Type


/**
 * @author : Yzq
 * time : 2020/11/9 16:52
 */
//@Parser(name = "Response", wrappers = [PageList::class, List::class])
open class BaseResponseParser<T> : AbstractParser<T> {
    /**
     * 此构造方法适用于任意Class对象，但更多用于带泛型的Class对象，如：List<Student>
     *
     * 用法:
     * Java: .asParser(new ResponseParser<List<Student>>(){})
     * Kotlin: .asParser(object : ResponseParser<List<Student>>() {})
     *
     * 注：此构造方法一定要用protected关键字修饰，否则调用此构造方法将拿不到泛型类型
     */
    protected constructor() : super()

    /**
     * 此构造方法仅适用于不带泛型的Class对象，如: Student.class
     *
     * 用法
     * Java: .asParser(new ResponseParser<>(Student.class))   或者  .asResponse(Student.class)
     * Kotlin: .asParser(ResponseParser(Student::class.java)) 或者  .asResponse<Student>()
     */
    constructor(type: Type) : super(type)

    @Throws(IOException::class)
    override fun onParse(response: okhttp3.Response): T {

        val type: Type = ParameterizedTypeImpl[BaseResponse::class.java, mType] //获取泛型类型
        val data: BaseResponse<T> = response.convert(type)
        var t = data.data //获取data字段

//        val headers = response.headers
//        headers.filter { it.first == "set-cookie" }.forEach {
//            LogUtils.eTag("asdsadas", it.second)
//        }
        if (t == null && mType === String::class.java) {
            /*
             * 考虑到有些时候服务端会返回：{"errorCode":0,"errorMsg":"关注成功"}  类似没有data的数据
             * 此时code正确，但是data字段为空，直接返回data的话，会报空指针错误，
             * 所以，判断泛型为String类型时，重新赋值，并确保赋值不为null
             */
            @Suppress("UNCHECKED_CAST")
            t = data.message as T
        }

        if (data.status != 0) { //data.status == -500 未登录，或者给占线
            throw ParseException(data.status.toString(), data.message, response)
        }

        if (!data.isSucceed() || t == null) { //code不等于0，说明数据不正确，抛出异常
            throw ParseException(data.code, data.message, response)
        }
        /**
         * 数据显示，msg 也要显示的情况
         */
//        if(data.isSucceed() && !data.message.isNullOrBlank()){
//             TxkToastUtil.showCentreText.showShort(data.message)
//        }
        return t
    }
}
