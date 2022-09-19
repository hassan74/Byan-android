package com.hassan.byantask.usecase.errors

import com.hassan.byantask.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): com.hassan.byantask.data.dto.error.Error
}
