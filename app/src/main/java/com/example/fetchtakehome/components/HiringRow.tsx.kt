package com.example.fetchtakehome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchtakehome.model.HiringItem
import com.example.fetchtakehome.ui.theme.FetchLightPurple

@Composable
fun HiringRow(
    item: HiringItem
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(20))
            .background(color = FetchLightPurple)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .background(color = FetchLightPurple),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                text = "ID: " + item.id
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                text = (item.name ?: "Not found")
            )
        }
    }
}