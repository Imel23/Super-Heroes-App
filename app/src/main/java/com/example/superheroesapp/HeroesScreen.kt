package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

@Composable
fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ){
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)){
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                    )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Box(Modifier
                .size(72.dp)
                .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(id = hero.nameRes),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopCenter
                )
            }
        }
    }
}

@Composable
fun SuperHeroList(heroesData: List<Hero>,
                  contentPadding: PaddingValues = PaddingValues(0.dp),
                  modifier: Modifier = Modifier){
    LazyColumn(
        contentPadding = contentPadding
    ){
        items(heroesData){
            SuperHeroItem(
                hero = it,
                Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SuperHeroItemPreview() {
    SuperheroesAppTheme {
        SuperHeroItem(        Hero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ))
    }

}

@Preview(showBackground = false)
@Composable
fun SuperHeroListPreview() {
    SuperheroesAppTheme {
        SuperHeroList(HeroesRepository.heroes)
    }

}