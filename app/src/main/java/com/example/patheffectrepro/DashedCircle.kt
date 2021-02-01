package com.example.patheffectrepro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

val pathEffectIntervalsDp: Array<Dp> = arrayOf(6.dp, 3.dp)
val strokeWidthDp = 1.dp

@Suppress("UNUSED_VARIABLE")
@Composable
fun DashedCircle(
    strokeColor: Color,
    modifier: Modifier = Modifier,
) {
    val pathEffectIntervals: FloatArray = pathEffectIntervalsDp.map {
        with (AmbientDensity.current) { it.toPx() }
    }.toFloatArray()
    val strokeWidth = with (AmbientDensity.current) { strokeWidthDp.toPx() }
    Box(modifier.drawWithCache {
        val pathEffect: PathEffect = PathEffect.dashPathEffect(pathEffectIntervals, 1f)
        val start = Offset(size.width / 2, size.height / 2)
        val end = Offset(size.width, size.height / 2)

        onDrawWithContent {
            drawCircle(
                strokeColor,
                style = Stroke(
                    width = strokeWidth,
                    pathEffect = null
                )
            )
            drawLine(
                color = strokeColor,
                start = start,
                end = end
            )
        }
    })
}

@Preview
@Composable
private fun DashedCirclePreview() {
    Box(modifier = Modifier.background(Color.White).padding(30.dp)) {
        DashedCircle(
            strokeColor = Color(0xFF7EC98B),
            modifier = Modifier.size(200.dp)
        )
    }
}
