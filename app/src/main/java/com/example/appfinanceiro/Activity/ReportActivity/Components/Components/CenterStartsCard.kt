package com.example.appfinanceiro.Activity.ReportActivity.Components.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.appfinanceiro.R

@Composable
fun CenterStartsCard(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(24.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {
        val (progressBar, totalTxtRef, totalLabel, statsRow) = createRefs()

        CircularProgressBar(
            progress = 60f,
            max = 100f,
            color = colorResource(R.color.blue),
            backgroundColor = colorResource(R.color.lightGrey),
            stroke = 15.dp,
            modifier = Modifier
                .size(175.dp)
                .constrainAs(progressBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "R$ 3.546,21",
            color = colorResource(R.color.darkBlue),
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier.constrainAs(totalTxtRef) {
                centerTo(progressBar)
            }
        )

        Text(
            text = "Total",
            color = colorResource(R.color.darkBlue),
            modifier = Modifier.constrainAs(totalLabel) {
                start.linkTo(totalTxtRef.start)
                top.linkTo(totalTxtRef.bottom)
                end.linkTo(totalTxtRef.end)
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .constrainAs(statsRow) {
                    top.linkTo(progressBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Receita
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        text = "Receita",
                        color = colorResource(R.color.darkBlue),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "R$ 3.245,21",
                        color = Color(0xFF2d9738),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }

            // Despesa
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        text = "Despesa",
                        color = colorResource(R.color.darkBlue),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "R$ 1.345,21",
                        color = Color(0xFFef2642),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CenterStatsCardPreview() {
    CenterStartsCard()
}