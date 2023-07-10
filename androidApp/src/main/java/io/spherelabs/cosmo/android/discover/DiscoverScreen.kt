package io.spherelabs.cosmo.android.discover

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.spherelabs.milkyway.android.R

@Composable
fun DiscoverScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val starts = listOf<PopularStar>(
        PopularStar("Earth", "100km"),
        PopularStar("Mars", "120km"),
        PopularStar("Venera", "120km"),
    )

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        backgroundColor = colorResource(id = R.color.dark_gray),
        topBar = {
            TopDiscover(url = "", name = "Behzod")
        },
        bottomBar = {
            BottomNavComponent(
                navController = navController,
                backgroundColor = colorResource(id = R.color.nero).copy(alpha = 0.5f),
                contentColor = colorResource(
                    id = R.color.white
                )
            )
        }
    ) { newPaddingValues ->
        Column(
            modifier = modifier.padding(newPaddingValues)
        ) {
            FlyWithCardItem()
            Spacer(modifier = modifier.height(32.dp))
            PopularTextStars()
            Spacer(modifier = modifier.height(32.dp))
            PopularStars(popularStars = starts)
            Spacer(modifier = modifier.height(32.dp))
            Text(
                modifier = modifier.padding(start = 24.dp),
                text = stringResource(id = R.string.articles),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = modifier.height(8.dp))
            ArticleItem(
                title = "Earth",
                description = stringResource(id = R.string.dummy_text),
                author = "Bla"
            )
        }
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
        backgroundColor = colorResource(id = R.color.nero)
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
        Text(
            text = stringResource(id = R.string.popular_stars),
            fontSize = 18.sp,
            color = colorResource(id = R.color.white)
        )
        Text(
            text = stringResource(id = R.string.view_all),
            fontSize = 14.sp,
            color = colorResource(id = R.color.white)
        )
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
fun PopularStars(
    modifier: Modifier = Modifier,
    popularStars: List<PopularStar>

) {
    LazyRow(
        modifier = modifier
            .padding(start = 14.dp)
            .fillMaxWidth()
    ) {
        items(items = popularStars, itemContent = { item ->
            PopularStart(
                name = item.name,
                distance = item.distance
            ) {
            }
        })
    }
}

@Composable
fun PopularStart(
    modifier: Modifier = Modifier,
    name: String,
    distance: String,
    onFlyClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .width(300.dp)
            .height(200.dp),
        shape = RoundedCornerShape(32.dp),
        backgroundColor = colorResource(id = R.color.nero)
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = modifier.size(150.dp),
                    painter = painterResource(id = R.drawable.earth),
                    contentDescription = null
                )
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = name,
                        color = colorResource(id = R.color.white)
                    )
                    Text(text = "0.16", color = colorResource(id = R.color.white))
                    Text(text = distance, color = colorResource(id = R.color.white))
                }
            }
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp),
                onClick = {
                    onFlyClick.invoke()
                }) {
                Text(text = stringResource(id = R.string.explore))
            }
        }
    }
}

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    author: String
) {
    Card(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp)
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(32.dp),
        backgroundColor = colorResource(id = R.color.nero)
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            Image(
                modifier = modifier
                    .width(150.dp)
                    .fillMaxHeight(),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.earth),
                contentDescription = null
            )
            Column(
                modifier = modifier.fillMaxSize()
            ) {
                Spacer(modifier = modifier.height(32.dp))
                Text(
                    text = title,
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    modifier = modifier.padding(end = 8.dp),
                    text = description,
                    maxLines = 4,
                    color = colorResource(id = R.color.white),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun DiscoverPreview() {
    DiscoverScreen()
}

data class PopularStar(
    val name: String,
    val distance: String,
)

data class Article(
    val title: String,
    val description: String,
    val author: String,
    val createdTimestamp: String
)