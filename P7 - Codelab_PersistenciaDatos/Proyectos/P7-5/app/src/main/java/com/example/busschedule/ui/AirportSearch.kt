package com.example.busschedule.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleDAO
import com.example.busschedule.ui.theme.BusScheduleTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun AirportSearch(
    viewModel: BusScheduleViewModel = viewModel(factory = BusScheduleViewModel.factory)
) {
    var query by remember { mutableStateOf("") }
    var searchResults by viewModel.getScheduleFor(it)
    Column {
        TextField(
            value = query,
            onValueChange = {
                query = it
                searchResults = viewModel.getScheduleFor("%$it%") // Search in the database
            },
            placeholder = { Text("Search for airports...") },
            modifier = Modifier.fillMaxWidth()

        )


        // Display search results
        Column {
            for (result in searchResults) {
                Text(text = "${result.stopName} (${result.id})")
            }
        }
    }
}