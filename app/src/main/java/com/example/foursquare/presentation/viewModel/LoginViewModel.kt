package com.example.foursquare.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foursquare.domain.useCase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor( private val  loginUseCase: LoginUseCase) : ViewModel() {

    private val _isLogin = MutableStateFlow(false)
    val login = _isLogin

    fun login(){
        viewModelScope.launch {
            loginUseCase()
            _isLogin.value = true
        }
    }
}