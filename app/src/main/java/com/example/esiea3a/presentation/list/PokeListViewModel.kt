package com.example.esiea3a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.PokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokeListViewModel : ViewModel(){

    val pokeList : MutableLiveData<PokemonModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList.value = PokemonLoader

        Singletons.pokeApi.getPokemonList().enqueue(object: Callback<PokeResponse> {
            override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                pokeList.value = PokemonError
            }

            override fun onResponse(call: Call<PokeResponse>, response: Response<PokeResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val pokemonResponse = response.body()!!
                    pokeList.value = PokemonSuccess(pokemonResponse.results)
                } else {
                    pokeList.value = PokemonError
                }
            }
        })
    }
}