package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                SuperHeroList(HeroesRepository.heroes)
            }
        }
    }
}

