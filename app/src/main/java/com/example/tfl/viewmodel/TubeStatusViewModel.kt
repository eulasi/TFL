package com.example.tfl.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfl.data.json.TflItem
import com.example.tfl.respository.TubeStatusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TubeStatusViewModel @Inject constructor(
    private val repository: TubeStatusRepository
) : ViewModel() {

    val tubeStatus = MutableLiveData<List<TflItem>>(emptyList())

    init {
        fetchTubeStatus()
    }

    private fun fetchTubeStatus() {
        viewModelScope.launch {
            val response = repository.getTubeStatus()
            if (response.isSuccessful) {
                tubeStatus.value = response.body()
                Log.d("TubeStatusViewModel", "Data fetched: ${tubeStatus.value}")
            } else {
                Log.e("TubeStatusViewModel", "Error fetching data: ${response.errorBody()}")
            }
        }
    }
}

