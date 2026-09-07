package com.example.appfinanceiro.Activity.ReportActivity.Components.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.appfinanceiro.Activity.DashboardActivity.Components.Components.BottomNavigationBar
import com.example.appfinanceiro.Activity.ReportActivity.Components.Components.GradientHeader
import com.example.appfinanceiro.Activity.ReportActivity.Components.Components.SummaryColumns
import com.example.appfinanceiro.Activity.ReportActivity.Components.Components.BudgetItem
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

@Composable
fun ReportScreen(
    budgets: List<BudgetDomain>,
    onBack: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (scrollRef, bottomNavRef) = createRefs()

        ReportContent(
            budgets = budgets,
            modifier = Modifier
                .constrainAs(scrollRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomNavRef.top)
                },
            onBack = onBack
        )

        BottomNavigationBar(
            modifier = Modifier
                .height(80.dp)
                .constrainAs(bottomNavRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onItemSelected = { itemId ->
                if (itemId == R.id.wallet) {

                }
            }
        )
    }
}

@Composable
fun ReportContent(
    budgets: List<BudgetDomain>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .background(Color.White),
    ) {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
            ) {
                val (header, card) = createRefs()
                GradientHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .constrainAs(header) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    onBack = onBack
                )
                CenterStatsCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp)
                        .constrainAs(card) {
                            top.linkTo(header.bottom)
                            bottom.linkTo(header.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
        }

        item {
            SummaryColumns(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .background(
                        color = colorResource(R.color.lightBlue),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Meu orçamento",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    color = colorResource(R.color.darkBlue)
                )
                Text("Edit", color = colorResource(R.color.darkBlue))
            }
        }

        itemsIndexed(budgets) { index, item ->
            BudgetItem(budget = item, index = index)
        }
    }
}

@Composable
fun CenterStatsCard(modifier: Modifier) {
    TODO("Not yet implemented")
}

@Preview
@Composable
fun ReportScreenPreview() {
    val budgets = listOf(
        BudgetDomain(title = "Automóvel", price = 100.0, percent = 20.0),
        BudgetDomain(title = "Imóvel", price = 500.0, percent = 50.0),
        BudgetDomain(title = "Viagens", price = 50.0, percent = 10.0)
    )
    ReportScreen(
        budgets = budgets,
        onBack = {}
    )
}