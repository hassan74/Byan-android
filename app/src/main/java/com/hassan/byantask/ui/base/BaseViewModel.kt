package com.hassan.byantask.ui.base

import androidx.lifecycle.ViewModel
import com.hassan.byantask.usecase.errors.ErrorManager
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var errorManager: ErrorManager
}