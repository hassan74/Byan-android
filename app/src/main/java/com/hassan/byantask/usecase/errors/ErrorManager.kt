package com.hassan.byantask.usecase.errors

import com.hassan.byantask.data.dto.error.Error
import com.hassan.byantask.data.dto.error.mapper.ErrorMapper
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}