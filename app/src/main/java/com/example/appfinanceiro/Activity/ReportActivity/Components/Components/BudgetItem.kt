package com.example.appfinanceiro.Activity.ReportActivity.Components.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.appfinanceiro.Domain.BudgetDomain
import com.example.appfinanceiro.R
import java.text.DecimalFormat

@Composable
fun BudgetItem(budget: BudgetDomain, index: Int) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        val (progress, title, price, percent) = createRefs()

        CircularProgressBar(
            progress = budget.percent.toFloat(),
            max = 100f,
            color = if ((index % 2) == 1) colorResource(R.color.blue) else colorResource(R.color.pink),
            backgroundColor = colorResource(R.color.lightGrey),
            stroke = 6.dp,
            modifier = Modifier
                .size(70.dp)
                .constrainAs(progress) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = "${budget.percent.toInt()}%",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(percent) {
                centerTo(progress)
            }
        )

        Text(
            text = budget.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(progress.end, margin = 16.dp)
                top.linkTo(progress.top, margin = 8.dp)
            }
        )

        Text(
            text = "R$ ${DecimalFormat("###,###,###,###").format(budget.price)} /mês",
            color = colorResource(R.color.grey),
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(price) {
                top.linkTo(title.bottom)
                start.linkTo(title.start)
            }
        )
    }
}

@Preview
@Composable
fun BudgetItemPreview() {
    val budget = BudgetDomain(title = "Alimentação", price = 1200.0, percent = 65.0)
    BudgetItem(budget = budget, index = 1)
}