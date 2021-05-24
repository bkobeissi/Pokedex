package com.example.esiea3a.presentation.list


sealed class PokemonModel

data class PokemonSuccess(val pokeList: List<Poke>) : PokemonModel()
object PokemonLoader : PokemonModel()
object PokemonError : PokemonModel()