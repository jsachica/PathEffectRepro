package com.example.patheffectrepro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

import com.example.patheffectrepro.ui.theme.PathEffectReproTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PathEffectReproTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Box(Modifier.fillMaxSize()) {
                        DashedCircle(
                            strokeColor = Color(0xFF7EC98B),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(300.dp)
                        )
                    }
                }
            }
        }
    }
}
