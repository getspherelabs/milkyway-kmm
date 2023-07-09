package io.spherelabs.cosmo.android.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.spherelabs.milkyway.android.R

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_gray))
    ) {
        TopDiscover(url = "", name = "Behzod")
        Spacer(modifier = modifier.height(32.dp))
        FlyWithCardItem()
        Spacer(modifier = modifier.height(32.dp))
        PopularTextStars()
    }
}

@Composable
fun TopDiscover(
    modifier: Modifier = Modifier,
    url: String,
    name: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        UserImageDiscover(
            url = url
        )
        Spacer(modifier = modifier.width(8.dp))
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = colorResource(id = R.color.white),
            maxLines = 1
        )
    }
}

@Composable
fun FlyWithCardItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(165.dp)
            .padding(start = 24.dp, end = 24.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xff161616)
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(modifier = modifier.fillMaxHeight()) {
                Text(
                    modifier = modifier.padding(start = 8.dp, top = 8.dp),
                    text = "Fly with \nstars",
                    color = Color.White,
                    fontSize = 24.sp
                )
                Spacer(modifier = modifier.height(24.dp))
                FlyButton {}
            }

            Column() {
                Image(
                    modifier = modifier.size(150.dp),
                    painter = painterResource(id = R.drawable.vr_planet), contentDescription = null
                )
            }
        }
    }
}

@Composable
fun FlyButton(
    modifier: Modifier = Modifier,
    onFlyClick: () -> Unit
) {
    Button(
        modifier = modifier
            .width(width = 93.dp)
            .height(height = 46.dp),
        onClick = { onFlyClick.invoke() },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xff7020c4)
        )
    ) {
        Text(text = "Fly", fontSize = 16.sp, color = colorResource(id = R.color.white))
    }
}

@Composable
fun PopularTextStars(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Popular starts", fontSize = 18.sp, color = colorResource(id = R.color.white))
        Text(text = "View All", fontSize = 14.sp, color = colorResource(id = R.color.white))
    }
}

@Composable
fun UserImageDiscover(
    modifier: Modifier = Modifier,
    url: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.vr_planet),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(6.dp, Color(0xff63219d), CircleShape)
    )

}


@Composable
fun PopularStart(
    modifier: Modifier
) {

}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun DiscoverPreview() {
    DiscoverScreen()
}