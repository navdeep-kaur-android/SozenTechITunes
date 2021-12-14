package com.navdeepkaur.sozentechitunes.movies

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.navdeepkaur.sozentechitunes.R
import com.navdeepkaur.sozentechitunes.base.BaseFragment
import com.navdeepkaur.sozentechitunes.databinding.FragmentMoviesGridBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesGridFragment : BaseFragment(), SearchView.OnQueryTextListener {
    override val viewModel: MoviesGridViewModel by viewModel()
    lateinit var binding : FragmentMoviesGridBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movies_grid, container,false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.moviesRecyclerView.adapter = MoviesGridAdapter(MoviesGridAdapter.OnClickListener{ result->
                findNavController().navigate(MoviesGridFragmentDirections.viewMovieDetails(result))
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(data: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(data: String?): Boolean {
        viewModel.searchMovies(data ?: "")
        return true
    }
}