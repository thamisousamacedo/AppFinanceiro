package com.example.appfinanceiro.Activity.DashboardActivity.Components

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appfinanceiro.ViewModel.MainViewModel
import com.example.appfinanceiro.ui.theme.AppFinanceiroTheme
import com.example.appfinanceiro.Activity.ReportActivity.Components.ReportActivity
import com.example.appfinanceiro.Activity.DashboardActivity.Screens.MainScreen

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFinanceiroTheme {
                MainScreen(expenses = mainViewModel.loadData(), onCardClick = {
                    android.util.Log.d("MainActivity", "onCardClick invoked")
                    startActivity(Intent(this@MainActivity, ReportActivity::class.java))
                })
            }
        }
    }
}
