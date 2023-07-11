package io.spherelabs.cosmo.android.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.spherelabs.cosmo.android.component.SearchBar
import io.spherelabs.cosmo.android.favourite.FavouriteItem
import io.spherelabs.milkyway.android.R


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.dark_gray))) {
        Spacer(modifier = modifier.height(24.dp))
        SearchBar(onSearch = {})
        SearchItems(newItems = listOf("Earth", "Mars", "Moon"))
    }
}
@Composable
fun SearchItems(
    modifier: Modifier = Modifier,
    newItems: List<String>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        items(items = newItems, itemContent = { newItem ->
            FavouriteItem(title = newItem, description = newItem)
        })
    }
}
@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Card(
        modifier = modifier
            .padding(
                top = 24.dp, bottom = 24.dp
            )
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
@Preview
@Composable
fun SearchPreviewScreen() {
    SearchScreen()
}