package com.example.sunbase_task.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.example.sunbase_task.db.Converters
import com.example.sunbase_task.db.Image
import com.example.sunbase_task.network.Resource
import com.example.sunbase_task.network.properties.ImageObjectResponse
import com.example.sunbase_task.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val mainRepository: MainRepository,
    val context: Application
) : AndroidViewModel(context) {

    private val _data = MutableLiveData<Resource<ImageObjectResponse>>()
    val data: LiveData<Resource<ImageObjectResponse>>
    get() = _data

    private val _cachedImages = MutableLiveData<List<Image>>()
    val cachedImages: LiveData<List<Image>>
    get() = _cachedImages


    fun getImagesFromNetwork() = viewModelScope.launch {
        _data.postValue(Resource.loading(null))
        mainRepository.getImagesFromNetwork().let {
            if(it.isSuccessful) {
                _data.postValue(Resource.success(it.body()))
                it.body()?.let { it1 -> cacheImagesToDatabase(it1) }
            }
            else _data.postValue(Resource.error(it.errorBody().toString(), null))
        }

    }

    fun cacheImagesToDatabase(data: ImageObjectResponse) = viewModelScope.launch(Dispatchers.IO) {
        mainRepository.deleteAllImages()
        for(e in data) {
            val bitmap = Glide.with(context).asBitmap().load(e.urls.regular).submit().get()
            val converter = Converters()
            val image = Image()
            image.bitmapImage = converter.fromBitmap(bitmap)
            mainRepository.insertImage(image)
        }
    }

    fun getCachedImagesFromDatabase() {
        _cachedImages.postValue(mainRepository.getAllImages().value)
    }

}