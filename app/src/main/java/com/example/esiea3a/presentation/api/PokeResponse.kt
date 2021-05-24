package com.example.esiea3a.presentation.api

import com.example.esiea3a.presentation.list.Poke


data class PokeResponse(
    val count: Int,
    val next: String,
    val results: List<Poke>
)