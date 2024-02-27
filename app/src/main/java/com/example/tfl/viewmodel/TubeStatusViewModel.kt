package com.example.tfl.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfl.data.networking.TflItem
import com.example.tfl.respository.TubeStatusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TubeStatusViewModel @Inject constructor(
    private val repository: TubeStatusRepository
) : ViewModel() {

    val tubeStatus = MutableLiveData<List<TflItem>>()
    val errorMessage = MutableLiveData<String>()

    init {
        fetchTubeStatus()
    }

    private fun fetchTubeStatus() {
        viewModelScope.launch {
            try {
                val response = repository.getTubeStatus()
                if (response.isSuccessful) {
                    tubeStatus.value = response.body()
                    Log.d("TubeStatusViewModel", "Data fetched: ${tubeStatus.value}")
                } else {
                    errorMessage.value = "Error fetching data: ${response.errorBody()}"
                    Log.e("TubeStatusViewModel", errorMessage.value!!)
                }
            } catch (e: Exception) {
                errorMessage.value = "Exception occurred: ${e.message}"
                Log.e("TubeStatusViewModel", errorMessage.value!!)
            }
        }
    }
}

