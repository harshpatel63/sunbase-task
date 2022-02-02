package com.example.sunbase_task.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunbase_task.network.Resource
import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    private val _text = MutableLiveData<Resource<ImageObjectResponse>>()
    val text: LiveData<Resource<ImageObjectResponse>>
    get() = _text

    init {
        getImagesFromNetwork()
    }

    private fun getImagesFromNetwork() = viewModelScope.launch {
        _text.postValue(Resource.loading(null))
        mainRepository.getImagesFromNetwork().let {
            if(it.isSuccessful)
                _text.postValue(Resource.success(it.body()))
            else _text.postValue(Resource.error(it.errorBody().toString(), null))
        }

    }

}