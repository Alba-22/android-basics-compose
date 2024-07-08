package dev.alba.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alba.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Composable
fun Main() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFa6ffc5)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.weight(1f))
                HeaderWidget()
                Spacer(modifier = Modifier.weight(1f))
                BottomWidget()
                Box(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun HeaderWidget() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier.height(80.dp).background(Color(0xFF000e1a)),

        )
        Text("Gustavo Alba", fontSize = 32.sp)
        Text(
            "Mobile Developer Expert",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00541d)
        )
    }
}

@Composable
fun BottomWidget() {
    Column {
        ContactWidget(icon = Icons.Rounded.Phone, text = "(16) 98159-8872")
        Box(modifier = Modifier.height(8.dp))
        ContactWidget(icon = Icons.Rounded.Share, text = "@alba.dev")
        Box(modifier = Modifier.height(8.dp))
        ContactWidget(icon = Icons.Rounded.Email, text = "contato@alba.dev")
    }
}

@Composable
fun ContactWidget(icon: ImageVector, text: String) {
    Row {
        Icon(icon, contentDescription = null, tint = Color(0xFF00541d))
        Box(modifier = Modifier.width(12.dp))
        Text(text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Main()
}