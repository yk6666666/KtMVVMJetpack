package com.dream.xiaobei.login

import android.os.Bundle
import com.dream.xiaobei.databinding.ActivityLoginBinding
import com.dream.xiaobei.main.MainActivity
import com.dream.xiaobei.main.MainViewModel
import com.tcl.base.common.ui.BaseActivity
import com.tcl.base.kt.ktClick
import com.tcl.base.kt.ktStartActivity

class LoginActivity : BaseActivity<MainViewModel, ActivityLoginBinding>(){
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mBinding.btnLogin.ktClick{
            ktStartActivity(MainActivity::class)
        }
        mBinding.tvLoginByOtherWay.ktClick {
            ktStartActivity(AccountPasswordActivity::class)
        }
        viewModel.mainViewResult.observe(this){
            it.let {

            }
        }
    }

    override fun initDataOnResume() {
    }

}