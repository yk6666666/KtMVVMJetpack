package com.dream.xiaobei.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dream.xiaobei.databinding.ActivityAccountPasswordBinding
import com.dream.xiaobei.databinding.ActivityLoginBinding
import com.dream.xiaobei.main.MainActivity
import com.dream.xiaobei.main.MainViewModel
import com.tcl.base.common.ui.BaseActivity
import com.tcl.base.kt.ktClick
import com.tcl.base.kt.ktStartActivity
import com.tcl.base.kt.ktToastShow

class AccountPasswordActivity : BaseActivity<MainViewModel, ActivityAccountPasswordBinding>(){
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mBinding.btnLogin.ktClick {
            if (mBinding.etPhoneEdit.text.toString().trim() == ""){
                "用户名不能为空".ktToastShow()
                return@ktClick
            }
            if (mBinding.etPasswordEdit.text.toString().trim() == ""){
                "密码不能为空".ktToastShow()
                return@ktClick
            }
            ktStartActivity(MainActivity::class)
        }
    }

    override fun initDataOnResume() {
    }

}