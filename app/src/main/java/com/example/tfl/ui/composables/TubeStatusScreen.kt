package com.example.tfl.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tfl.viewmodel.TubeStatusViewModel

@Composable
fun TubeStatusScreen(tubeStatusViewModel: TubeStatusViewModel = viewModel()) {
    val tubeStatus by tubeStatusViewModel.tubeStatus.observeAsState(initial = emptyList())

    LazyColumn {
        items(tubeStatus) { tflItem ->
            TubeStatusItem(tflItem)
        }
    }

}