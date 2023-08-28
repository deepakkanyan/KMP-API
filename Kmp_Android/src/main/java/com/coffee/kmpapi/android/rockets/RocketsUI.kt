package com.coffee.kmpapi.android.rockets


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.coffee.kmpapi.impl.rockets.data.RocketModel
import com.coffee.kmpapi.impl.rockets.data.RocketResponse

@Composable
fun RocketsUI() {
    val viewModel: RocketViewModel = viewModel()
    val rocket = viewModel.rocketList.collectAsState().value

    Box(modifier = Modifier) {
        RocketView(rocket)
    }
}

@Composable
fun BoxScope.RocketView(rocket: RocketResponse) {

    when (rocket) {
        is RocketResponse.Loading -> {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        is RocketResponse.Success -> {
            ShowRocketList(rocket.data)
        }

        is RocketResponse.Error -> {
            Text(text = rocket.e.toString(), modifier = Modifier.align(Alignment.Center))
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowRocketList(rocket: List<RocketModel>) {
    LazyColumn {
        items(rocket) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)

            ) {
                val pagerState = rememberPagerState(pageCount = { it.rocketsImages.size })
                Column {
                    HorizontalPager(state = pagerState) { position ->

                        Box(modifier = Modifier) {
                            AsyncImage(
                                model = it.rocketsImages[position],
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)

                            )
                            Text(
                                text = "${it.rocketsImages.size} images",
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(10.dp)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = it.name, style = MaterialTheme.typography.titleLarge)
                        Text(text = it.company, style = MaterialTheme.typography.labelMedium)
                        Text(
                            text = it.description, style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )

                    }

                }

            }
        }
    }
}
