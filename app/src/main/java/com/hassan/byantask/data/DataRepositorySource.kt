package com.hassan.byantask.data

import com.hassan.byantask.data.dto.login.LoginRequest
import com.hassan.byantask.data.dto.login.LoginResponse
import kotlinx.coroutines.flow.Flow

 

interface DataRepositorySource {
    suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
}
