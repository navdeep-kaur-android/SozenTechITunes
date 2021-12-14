package com.navdeepkaur.sozentechitunes.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.navdeepkaur.sozentechitunes.data.network.Results
import com.navdeepkaur.sozentechitunes.databinding.MoviesItemLayoutBinding


/**
 * Created by Navdeep Kaur on 12/13/2021
 * navdeep.kaur36026@gmail.com
 */
class MoviesGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<Results, MoviesGridAdapter.MovieViewHolder>(DiffCallback){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MoviesItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(movie)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Results>(){
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return  oldItem.trackId == newItem.trackId
        }
    }

    class MovieViewHolder(private var binding: MoviesItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(result: Results){
            binding.result = result
            binding.executePendingBindings()
        }
    }


    class OnClickListener(val clickListener: (marsProperty: Results) -> Unit) {
        fun onClick(marsProperty:Results) = clickListener(marsProperty)
    }

}

