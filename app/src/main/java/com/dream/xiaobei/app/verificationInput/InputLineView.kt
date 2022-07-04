package com.dream.xiaobei.app.verificationInput

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dream.xiaobei.databinding.ViewInputLineBinding

/**
 *
 *  Author:yk
 *  Date:2021/7/21
 *
 */
class InputLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    var mBinding: ViewInputLineBinding

    init {
        mBinding = ViewInputLineBinding.inflate(LayoutInflater.from(context))
        addView(mBinding.root)
    }

    fun setText(text : String){
        mBinding.pwdTv.text = text
    }
}