package com.example.appfinanceiro.Activity.IntroActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appfinanceiro.Activity.IntroActivity.Screens.IntroScreen
import com.example.appfinanceiro.Activity.DashboardActivity.Components.MainActivity

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroScreen(onStartClick = {
                startActivity(Intent(this, MainActivity::class.java))
            })

        }
    }
}