package com.navdeepkaur.sozentechitunes.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.navdeepkaur.sozentechitunes.R
import com.navdeepkaur.sozentechitunes.data.network.Results
import com.navdeepkaur.sozentechitunes.movies.MoviesGridAdapter


/**
 * Created by Navdeep Kaur on 12/13/2021
 * navdeep.kaur36026@gmail.com
 */
object BindingAdapter {

    /**
     * Use binding adapter to set the recycler view data using livedata object
     */
    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("listData")
    @JvmStatic
    fun setRecyclerViewData(recyclerView: RecyclerView, items: LiveData<List<Results>>?) {
        items?.value?.let {
            val adapter = recyclerView.adapter as MoviesGridAdapter
            adapter.submitList(it)
        }
    }

    /**
     * Use this binding adapter to show and hide the views using boolean variables
     */
    @BindingAdapter("fadeVisible")
    @JvmStatic
    fun setFadeVisible(view: View, visible: Boolean? = true) {
        if (view.tag == null) {
            view.tag = true
            view.visibility = if (visible == true) View.VISIBLE else View.GONE
        } else {
            view.animate().cancel()
            if (visible == true) {
                if (view.visibility == View.GONE)
                    view.fadeIn()
            } else {
                if (view.visibility == View.VISIBLE)
                    view.fadeOut()
            }
        }
    }

    @BindingAdapter("imageURL")
    @JvmStatic
    fun bindImage(imageView: ImageView, url: String?) {
        url?.let {
            GlideApp.with(imageView.context)
                .load(url)
                .error(R.drawable.image_placeholder)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }
    }


    @BindingAdapter("textVisibility")
    @JvmStatic
    fun bindTextVisibility(textView: TextView, data: String?) {
        if(data == null || data.isEmpty()){
            textView.visibility = View.INVISIBLE
        }
    }

}
