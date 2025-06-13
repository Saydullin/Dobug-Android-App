package com.saydullin.dobugapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.data.datastore.JwtSecurityDataStore
import com.saydullin.dobugapp.util.NavScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val jwtSecurityDataStore: JwtSecurityDataStore
): ViewModel() {

    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination: StateFlow<String?> = _startDestination

    init {
        viewModelScope.launch(Dispatchers.IO) {
            jwtSecurityDataStore.getJwtKey().collect { token ->
                _startDestination.value = if (token.isNotBlank()) {
                    NavScreen.Home.route
                } else {
                    NavScreen.SignIn.route
                }
            }
        }
    }

}