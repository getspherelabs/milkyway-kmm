package io.spherelabs.cosmo.android.aboutme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.spherelabs.cosmo.android.component.BackButton
import io.spherelabs.cosmo.android.component.LinearLine
import io.spherelabs.cosmo.android.component.RoundedImage
import io.spherelabs.milkyway.android.R

@Composable
fun AboutMeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = colorResource(id = R.color.dark_gray),
        topBar = {
            TopAboutBar()
        }
    ) { newPaddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(newPaddingValues)
        ) {
            Spacer(modifier = modifier.height(32.dp))
            RoundedImage(
                modifier = modifier
                    .padding(start = 24.dp),
                imageUrl = "",
                imageSize = 64,
                borderWidth = 8
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                modifier = modifier.padding(start = 24.dp),
                text = "Behzod",
                fontSize = 22.sp,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = modifier.height(8.dp))
            LinearLine()
            Spacer(modifier = modifier.height(24.dp))
            AboutDescription(description = "Bla bla")
            Spacer(modifier = modifier.height(24.dp))
            FavouritePlanet(name = "Mars")
            Spacer(modifier = modifier.height(8.dp))
            LinearLine()
            Spacer(modifier = modifier.height(24.dp))
            InterestedIn(category = "Planets")
        }
    }
}

@Composable
fun AboutDescription(
    modifier: Modifier = Modifier,
    description: String
) {
    Text(
        modifier = modifier.padding(start = 24.dp),
        text = "About",
        fontSize = 22.sp,
        color = colorResource(id = R.color.white)
    )
    Text(
        modifier = modifier.padding(start = 24.dp),
        text = description,
        fontSize = 16.sp,
        color = colorResource(id = R.color.white).copy(alpha = 0.7F)
    )
}

@Composable
fun TopAboutBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BackButton()
        Text(
            text = "Edit",
            color = colorResource(id = R.color.white),
            fontSize = 16.sp
        )
    }
}



@Composable
fun FavouritePlanet(
    modifier: Modifier = Modifier,
    name: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_reshot),
            contentDescription = null
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(text = "Favourite Planet", color = colorResource(id = R.color.white), fontSize = 14.sp)
        Spacer(Modifier.weight(1f))
        Text(
            text = name,
            textAlign = TextAlign.Left,
            color = colorResource(id = R.color.white).copy(alpha = 0.6F)
        )
    }
}

@Composable
fun InterestedIn(
    modifier: Modifier = Modifier,
    category: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_alien),
            contentDescription = null
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(text = "Interested in", color = colorResource(id = R.color.white), fontSize = 14.sp)
        Spacer(Modifier.weight(1f))
        Text(
            text = category,
            textAlign = TextAlign.Left,
            color = colorResource(id = R.color.white).copy(alpha = 0.6F)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutMePreviewScreen() {
    AboutMeScreen()
}