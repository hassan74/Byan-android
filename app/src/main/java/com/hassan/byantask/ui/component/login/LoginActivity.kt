package com.hassan.byantask.ui.component.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import com.hassan.byantask.ui.component.home.HomeActivity
import com.hassan.byantask.R
import com.hassan.byantask.data.Resource
import com.hassan.byantask.data.dto.login.LoginResponse
import com.hassan.byantask.databinding.ActivityLoginBinding
import com.hassan.byantask.ui.base.BaseActivity
import com.hassan.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun observeViewModel() {
        observe(loginViewModel.loginLiveData, ::handleLoginResult)
        observeSnackBarMessages(loginViewModel.showSnackBar)
        observeToast(loginViewModel.showToast)
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btLogin.setOnClickListener { doLogin() }


    }

    private fun doLogin() {
        loginViewModel.doLogin(
            binding.loginEmail.text.trim().toString(),
            binding.loginPassword.text.toString()
        )
    }

    private fun handleLoginResult(status: Resource<LoginResponse>) {
        when (status) {
            is Resource.Loading -> binding.loader.toVisible()
            is Resource.Success -> status.data?.let {
                binding.loader.toGone()
                navigateToMainScreen()
            }
            is Resource.DataError -> {
                binding.loader.toGone()
                status.errorCode?.let { loginViewModel.showToastMessage(it) }
            }
        }
    }

    private fun navigateToMainScreen() {
        val nextScreenIntent = Intent(this, HomeActivity::class.java)
        startActivity(nextScreenIntent)
        finish()
    }

    private fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>) {
        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }

    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }
}