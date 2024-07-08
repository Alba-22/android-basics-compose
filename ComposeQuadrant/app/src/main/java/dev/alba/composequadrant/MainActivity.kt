package dev.alba.composequadrant

import android.content.pm.ModuleInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.alba.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier.weight(0.5F),
        ) {

            Cube(
                stringResource(R.string.first_title),
                stringResource(R.string.first_text),
                Color(0xFFEADDFF),
                modifier = Modifier.weight(0.5F),
            )
            Cube(
                stringResource(R.string.second_title),
                stringResource(R.string.second_text),
                Color(0xFFD0BCFF),
                modifier = Modifier.weight(0.5F),
            )
        }
        Row(
            modifier = Modifier.weight(0.5F),
        ) {
            Cube(
                stringResource(R.string.third_title),
                stringResource(R.string.third_text),
                Color(0xFFB69DF8),
                modifier = Modifier.weight(0.5F),
            )
            Cube(
                stringResource(R.string.fourth_title),
                stringResource(R.string.fourth_text),
                Color(0xFFF6EDFF),
                modifier = Modifier.weight(0.5F),
            )
        }
    }
}

@Composable
fun Cube(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Surface(color = color, modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
            Text(text, textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        Page()
    }
}