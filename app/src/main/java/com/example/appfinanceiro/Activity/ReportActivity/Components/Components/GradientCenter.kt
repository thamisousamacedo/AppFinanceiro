package com.example.appfinanceiro.Activity.ReportActivity.Components.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
fun GradientHeader(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(
                Brush.linearGradient(
                    colors = listOf(colorResource(R.color.lightBlue), Color(0xffA241DD)),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                ),
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            )
    ) {
        val (backBtn, title) = createRefs()
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(top = 32.dp)
                .size(48.dp)
                .constrainAs(backBtn) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Voltar",
                tint = Color.White
            )
        }
        Text(
            text = "Relatório Mensal",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(backBtn.end, margin = 8.dp)
                    top.linkTo(backBtn.top)
                    bottom.linkTo(backBtn.bottom)
                }
        )
    }
}

@Preview
@Composable
fun GradientHeaderPreview() {
    GradientHeader()
}