package com.example.sunbase_task.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunbase_task.network.Resource
import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.network.properties.SearchObjectResponse
import com.example.sunbase_task.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    private val _data = MutableLiveData<Resource<SearchObjectResponse>>()
    val data: LiveData<Resource<SearchObjectResponse>>
        get() = _data

    fun searchKeyword(keyword: String) {
        searchImageFromNetwork(keyword)
    }

    private fun searchImageFromNetwork(keyword: String) = viewModelScope.launch {
        _data.postValue(Resource.loading(null))
        mainRepository.searchImageFromNetwork(keyword).let {
            if(it.isSuccessful)
                _data.postValue(Resource.success(it.body()))
            else _data.postValue(Resource.error(it.errorBody().toString(), null))
        }

    }
}