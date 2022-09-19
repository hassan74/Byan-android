package com.hassan.byantask.data.dto.error.mapper

import android.content.Context
import com.hassan.byantask.R
import com.hassan.byantask.data.dto.error.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) : ErrorMapperSource {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error)),
            Pair(SEARCH_ERROR, getErrorString(R.string.search_error)),
            Pair(PASS_WORD_ERROR, getErrorString(R.string.passord_error)),
            Pair(USER_NAME_ERROR, getErrorString(R.string.username_error))
        ).withDefault { getErrorString(R.string.network_error) }
}
