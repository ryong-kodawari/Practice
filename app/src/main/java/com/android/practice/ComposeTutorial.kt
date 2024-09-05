package com.android.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeTutorial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Column {
                ShowImage()
            }
        }
    }
}

@Preview
@Composable
fun ShowImage() {
    Column(
        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var countTapClick by remember {
            mutableIntStateOf(0)
        }
        var countTapTriangle by remember {
            mutableIntStateOf(0)
        }
        Row {
            Text(
                text = "Click:$countTapClick ,",
                fontSize = 16.sp,
                color = colorResource(id = R.color.purple_200)
            )
            Text(
                text = "Triangle:$countTapTriangle",
                fontSize = 16.sp,
                color = colorResource(id = R.color.teal_200)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.icon_click), contentDescription = "",
                modifier = Modifier
                    .size(108.dp)
                    .border(1.dp, color = colorResource(id = R.color.teal_200))
                    .clickable { countTapClick++ },
                contentScale = ContentScale.Crop,
            )
            Image(
                painter = painterResource(id = R.drawable.triangle),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(108.dp)
                    .clickable { countTapTriangle++ })
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.icon_svg), contentDescription = "",
                modifier = Modifier
                    .size(108.dp)
                    .border(1.dp, color = colorResource(id = R.color.teal_200))
                    .clickable { countTapClick-- },
                contentScale = ContentScale.Crop,
            )
            Image(
                painter = painterResource(id = R.drawable.triangle_minus),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(108.dp)
                    .clickable { countTapTriangle-- })
        }
    }
}