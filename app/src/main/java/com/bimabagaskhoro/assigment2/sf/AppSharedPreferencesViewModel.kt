package com.bimabagaskhoro.assigment2.sf

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.assigment2.sf.AppSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppSharedPreferencesViewModel @Inject constructor(val sharedPreferences: AppSharedPreferences) : ViewModel(){
    private var _loginSession = sharedPreferences

    fun loginUser(username: String) {
        _loginSession.createLoginSession()
        _loginSession.saveToPreference(AppSharedPreferences.KEY_USERNAME, username)
    }

    fun getUser() = _loginSession.getFromPreference(AppSharedPreferences.KEY_USERNAME)

    fun isUserLogin() = _loginSession.isLogin

    fun logoutUser() = _loginSession.logout()

    fun checkInstance() = Log.d("Singleton", "checkInstance: $this")
}