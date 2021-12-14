package com.navdeepkaur.sozentechitunes.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.navdeepkaur.sozentechitunes.R
import com.navdeepkaur.sozentechitunes.databinding.FragmentMoviesDetailBinding


class MoviesDetailFragment : Fragment() {
private lateinit var binding: FragmentMoviesDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies_detail, container, false)
        binding.lifecycleOwner = this
        binding.result = MoviesDetailFragmentArgs.fromBundle(requireArguments()).result
        return binding.root
    }
}