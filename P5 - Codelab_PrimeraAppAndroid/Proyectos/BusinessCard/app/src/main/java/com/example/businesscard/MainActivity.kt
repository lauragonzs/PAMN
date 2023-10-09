package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.user_icon)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 16.sp
        )

        Row(
            modifier = Modifier.padding(top = 150.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.tlf)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )
            Text(
                text = stringResource(R.string.phone),
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 25.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.insta)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )
            Text(
                text = stringResource(R.string.socialmedia),
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 25.dp, bottom = 50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.mail)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )
            Text(
                text = stringResource(R.string.mail),
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}