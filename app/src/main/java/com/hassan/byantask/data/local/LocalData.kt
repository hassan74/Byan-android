package com.hassan.byantask.data.local

import android.content.Context
import com.hassan.byantask.data.Resource
import com.hassan.byantask.data.dto.login.LoginRequest
import com.hassan.byantask.data.dto.login.LoginResponse
import com.hassan.byantask.data.error.PASS_WORD_ERROR
import javax.inject.Inject

 

class LocalData @Inject constructor(val context: Context) {
    fun doLogin(loginRequest: LoginRequest): Resource<LoginResponse> {
        if (loginRequest == LoginRequest("mh.abdelhay@gmail.com", "12345")) {
            return Resource.Success(LoginResponse("1", "Mohamed", "Hassan",
                "Cairo", "123", "123", "Cairo",
                "Egypt", "mh.abdelhay@gmail.com"))
        }
        return Resource.DataError(PASS_WORD_ERROR)
    }

}

