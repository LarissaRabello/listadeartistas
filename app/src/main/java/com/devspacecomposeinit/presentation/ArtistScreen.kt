package com.devspacecomposeinit.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devspacecomposeinit.R
import com.devspacecomposeinit.domain.ArtistUseCase
import com.devspacecomposeinit.ui.theme.ComposeInitTheme
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devspacecomposeinit.ui.theme.radius_large

@Composable
fun ArtistScreen(
    navController: NavController
){
    var searchQuery by remember { mutableStateOf("") }

    val leonardo = ArtistUseCase(
        name = "Leonardo da Vinci",
        lastSeenOnline = "3 minutes ago",
        image = R.drawable.ic_leonardo_da_vinci,
        art = R.drawable.ic_mona_lisa
    )
    val picasso = ArtistUseCase(
        name = "Pablo Picasso",
        lastSeenOnline = "5 minutes ago",
        image = R.drawable.ic_pablo_picasso,
        art = R.drawable.ic_beijo
    )
    val salvador = ArtistUseCase(
        name = "Salvador Dali",
        lastSeenOnline = "7 minutes ago",
        image = R.drawable.ic_salvador_dali,
        art = R.drawable.ic_persistence_of_memory
    )
    val vanGogh = ArtistUseCase(
        name = "Vincent Van Gogh",
        lastSeenOnline = "10 minutes ago",
        image = R.drawable.ic_vincent_van_gogh,
        art = R.drawable.ic_starry_night
    )
    val artists = listOf(leonardo, picasso, salvador, vanGogh)

    val filteredArtists = if (searchQuery.isEmpty()) {
        artists
    } else {
        artists.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar artista...") },
                shape = RoundedCornerShape(radius_large),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            LazyColumn {
                items(filteredArtists) { artist ->
                    ArtistCard(
                        artist = artist,
                        onClick = {

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ArtistCard(
    artist: ArtistUseCase,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
            .clickable(onClick = onClick)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = artist.image),
                contentDescription = "Imagem do Artista"
            )
            Spacer(modifier = Modifier.size(16.dp))

            Column {
                Text(
                    text = artist.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold)

                Text(
                    text = artist.lastSeenOnline,
                    color = Color.Gray)
            }
        }
        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = artist.art),
                contentDescription = "Arte")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistScreenPreview() {
    val navController = rememberNavController()
    ArtistScreen(navController)
}