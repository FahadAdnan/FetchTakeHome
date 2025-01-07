package com.example.fetchtakehome.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchtakehome.MainViewModel
import com.example.fetchtakehome.components.HiringRow
import com.example.fetchtakehome.ui.theme.FetchPurple
import com.example.fetchtakehome.ui.theme.FetchYellow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val hiringList = mainViewModel.hiringItemState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                hiringList.value.forEach { (listID, hiringForListID) ->

                    stickyHeader {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20))
                                .background(color = FetchYellow)
                        ){
                            Text(
                                text = "List ID: $listID",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                                color = FetchPurple
                            )
                        }
                    }

                    items(hiringForListID.size) { index ->
                        HiringRow(item = hiringForListID[index])
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}
