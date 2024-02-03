package com.example.kotlin51.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInfoViewModel : ViewModel(){
    private var _userData = MutableLiveData<UserModel>()
    val userData:LiveData<UserModel> = _userData

    fun updateUserModel(userModel: UserModel){
        _userData.value = userModel
    }
}