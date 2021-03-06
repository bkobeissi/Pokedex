package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R


class PokeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var textViewError: TextView

    private val adapter = PokeAdapter(listOf(), ::onClickedPokemon)

    private val viewModel: PokeListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.pokemon_recyclerview)
        loader = view.findViewById(R.id.pokemon_loader)
        textViewError = view.findViewById(R.id.pokemon_error)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PokeListFragment.adapter
        }

        viewModel.pokeList.observe(viewLifecycleOwner, Observer { pokemonModel ->
            loader.isVisible = pokemonModel is PokemonLoader
            textViewError.isVisible = pokemonModel is PokemonError

            if(pokemonModel is PokemonSuccess) {
                adapter.updateList(pokemonModel.pokeList)
            }
        })
    }

    private fun onClickedPokemon(id: Int) {
        findNavController().navigate(R.id.navigateToPokemonDetailFragment, bundleOf(
            "pokemonId" to (id + 1)
        ))
    }
}