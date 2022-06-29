package com.dream.xiaobei.app.VerificationInput

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.dream.xiaobei.`interface`.PwdInputListener
import com.dream.xiaobei.app.InputLineView
import com.dream.xiaobei.databinding.ViewVerificationInputBinding

class VerificationInputView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    var mBinding: ViewVerificationInputBinding
    var mListener: PwdInputListener? = null
    val MAXlength = 4
    val viewList = ArrayList<InputLineView>()

    init {
        mBinding = ViewVerificationInputBinding.inflate(LayoutInflater.from(context))
        mBinding.edtInput.requestFocus()
        val childCount = mBinding.pwdLay.childCount
        for (i in 0 until childCount) {
            viewList.add(mBinding.pwdLay.getChildAt(i) as InputLineView)
        }
        onEvent()
        addView(mBinding.root)
    }

    fun setPasswordListener(listener: PwdInputListener) {
        mListener = listener
    }

    fun clearInput() {
        mBinding.edtInput.setText("")
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

                val inputContent = mBinding.edtInput.text.toString()
                mListener?.let {
                    if (inputContent.length >= MAXlength) {
                        it.onInputComplete(inputContent)
                    }
                }
                for (i in 0 until MAXlength) {
                    if (i < inputContent.length) {
                        viewList[i].setText(inputContent[i].toString())
                    } else {
                        viewList[i].setText("")
                    }
                }
            }
        })
    }
}