package com.example.appfinanceiro.Activity.DashboardActivity.Components.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfinanceiro.Activity.ReportActivity.Components.ReportActivity
import com.example.appfinanceiro.R

@Composable
fun CardSection(onClick: () -> Unit= {}) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(230.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                android.util.Log.d("CardSection", "onClick invoked")
                onClick()
                // Ensure navigation happens even if caller didn't provide action
                try {
                    context.startActivity(Intent(context, ReportActivity::class.java))
                } catch (_: Exception) {}
            }

    ) {
        Image(
            painter = painterResource(id = R.drawable.card),
            contentDescription = "Card Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.visa),
            contentDescription = "Card Logo",
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(16.dp)
        )
        Text(
            text = "9876 5432 1234 6549",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterStart)
                .padding(start = 16.dp, bottom = 16.dp)
        )
        Text(
            text = "11/38",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.CenterEnd)
                .padding(end = 16.dp, bottom = 16.dp)
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .align (Alignment.BottomCenter)
            .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
            .background(Color.White.copy(alpha = 0.2f))
            .padding(16.dp)
        ) {
            Column {
                Text(text = "Seu Saldo",
                    color = Color.White,
                    fontSize = 17.sp
                )
                Text(text = "R$ 28.351,11",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}