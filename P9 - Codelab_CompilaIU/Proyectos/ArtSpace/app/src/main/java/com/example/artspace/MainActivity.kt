package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

class ArtWork(
    val name: String,
    val author: String,
    val imageId: Int
)

@Composable
fun ArtSpace() {
    val artWorks: List<ArtWork> = listOf(
        ArtWork("Starry Night", "Vincent van Gogh (1889)", R.drawable.starry_night),
        ArtWork("Mona Lisa", "Leonardo da Vinci (1503)", R.drawable.mona_lisa),
        ArtWork("Water Lilies", "Claude Monet (1919)", R.drawable.water_lilies)
    )

    var currentArtWorkIndex by remember { mutableStateOf(0) }

    fun onPrevClick() {
        currentArtWorkIndex = (currentArtWorkIndex - 1 + artWorks.size) % artWorks.size
    }

    fun onNextClick() {
        currentArtWorkIndex = (currentArtWorkIndex + 1) % artWorks.size
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = artWorks[currentArtWorkIndex].imageId),
            contentDescription = "Cuadro Monet",
            modifier = Modifier
                .size(400.dp)
        )
        Text(text = artWorks[currentArtWorkIndex].name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = artWorks[currentArtWorkIndex].author, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onPrevClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE57373),
                    contentColor = Color.White),
                modifier = Modifier.width(150.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = { onNextClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE57373),
                    contentColor = Color.White),
                modifier = Modifier.width(150.dp)) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}