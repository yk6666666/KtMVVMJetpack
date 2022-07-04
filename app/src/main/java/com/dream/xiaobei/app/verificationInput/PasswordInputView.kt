package com.dream.xiaobei.app.verificationInput

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.dream.xiaobei.`interface`.PwdInputListener
import com.dream.xiaobei.databinding.ViewPasswordInputBinding

class PasswordInputView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    var mBinding: ViewPasswordInputBinding
    var mListener: PwdInputListener? = null
    val MAXlength = 6
    val viewList = ArrayList<TextView>()

    init {
        mBinding = ViewPasswordInputBinding.inflate(LayoutInflater.from(context))
        mBinding.edtInput.requestFocus()
        val childCount = mBinding.pwdLay.childCount
        for (i in 0 until childCount) {
            viewList.add(mBinding.pwdLay.getChildAt(i) as TextView)
        }
        onEvent()
        addView(mBinding.root)
    }

    fun setPasswordListener(listener: PwdInputListener) {
        mListener = listener
    }

    fun clearInput() {
        mBinding.edtInput?.setText("")
    }

    fun onEvent() {
        mBinding.edtInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                var inputContent = mBinding.edtInput.text.toString()
                mListener?.let {
                    if (inputContent.length >= MAXlength) {
                        it.onInputComplete(inputContent)
                    }
                }
                for (i in 0 until MAXlength) {
                    if (i < inputContent.length) {
                        viewList.get(i).setText(inputContent[i].toString())
                    } else {
                        viewList.get(i).setText("")
                    }
                }
            }
        })
    }
}