package com.practical

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practical.viewmodel.ThrowError


//import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel() {

//    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val isThrowData: MutableLiveData<ThrowError> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isError: MutableLiveData<Throwable> = MutableLiveData()

    override fun onCleared() {
//        compositeDisposable.clear()
        super.onCleared()
    }

}