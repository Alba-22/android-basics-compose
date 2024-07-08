package dev.alba.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alba.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageContent()
                }
            }
        }
    }
}

@Composable
fun PageContent() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = stringResource(R.string.bg_compose_background_description_text)
        )
        Text(
            stringResource(R.string.title_text),
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            stringResource(R.string.summary_text),
            modifier = Modifier.padding(start = 16.dp).padding(end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            stringResource(R.string.description_text),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        PageContent()
    }
}