package com.ambrosio.gamebank.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ambrosio.gamebank.R
import com.ambrosio.gamebank.adapters.VideoGameAdapter
import com.ambrosio.gamebank.ui.trending.TrendingViewModel
import java.util.*

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var favoriteGamesAdapter : VideoGameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel  = ViewModelProvider(this).get(TrendingViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initView(view: View){
        val etHeader: EditText = view.findViewById(R.id.etHeader)
        etHeader.setText(getString(R.string.title_favorite_games).toUpperCase(Locale.ROOT))

        val favoriteGamesRV = view.findViewById<RecyclerView>(R.id.favoritesRV)
        favoriteGamesRV.layoutManager = GridLayoutManager(context, 2)

        favoriteGamesAdapter = VideoGameAdapter()
        favoriteGamesRV.adapter = favoriteGamesAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
//        viewModel.getTrendingListObserver().observe(viewLifecycleOwner, { videoGames ->
//            favoriteGamesAdapter.setUpdatedData(videoGames)
//        })
//
//        viewModel.fetchTrending()
    }
}