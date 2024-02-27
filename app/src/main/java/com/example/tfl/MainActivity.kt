package com.example.tfl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tfl.data.networking.TflItem
import com.example.tfl.ui.generateRandomColor
import com.example.tfl.viewmodel.TubeStatusViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TubeStatusScreen()
        }
    }
}

@Composable
fun TubeStatusScreen(tubeStatusViewModel: TubeStatusViewModel = viewModel()) {
    val tubeStatus = tubeStatusViewModel.tubeStatus.value ?: emptyList()

    LazyColumn {
        items(tubeStatus) { tflItem ->
            TubeStatusItem(tflItem)
        }
    }
}
@Composable
fun TubeStatusItem(tflItem: TflItem) {
    var isExpanded by remember { mutableStateOf(false) }
    val backgroundColor by remember { mutableStateOf(generateRandomColor()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded }
    ) {
        Row {
            Box(
                modifier = Modifier
                    .background(backgroundColor)
                    .size(width = 20.dp, height = 80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = tflItem.name ?: "",
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                style = TextStyle(fontSize = 22.sp),
                modifier = Modifier
                    .padding(22.dp)
            )
        }
        Divider()
        AnimatedVisibility(visible = isExpanded) {
            Column {
                tflItem.lineStatuses?.forEach { status ->
                    status?.let {
                        Text(
                            text = "${it.statusSeverityDescription} ${it.reason ?: "No reason provided"}",
                            textAlign = TextAlign.Left,
                            fontFamily = FontFamily.SansSerif,
                            style = TextStyle(fontSize = 22.sp),
                            modifier = Modifier
                                .padding(start = 52.dp, top = 22.dp, bottom = 22.dp, end = 22.dp)
                        )
                    }
                }
            }
        }
    }
}
