package com.example.appfinanceiro.Activity.ReportActivity.Components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.appfinanceiro.Activity.ReportActivity.Components.Screens.ReportScreen
import com.example.appfinanceiro.ViewModel.MainViewModel

class ReportActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReportScreen(
                            budgets = mainViewModel.loadBudget(),
                onBack = { finish() }
            )
        }
    }
}