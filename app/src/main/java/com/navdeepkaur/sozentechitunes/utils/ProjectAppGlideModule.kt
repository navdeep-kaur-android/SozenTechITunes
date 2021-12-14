package com.navdeepkaur.sozentechitunes.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Navdeep Kaur on 12/13/2021
 * navdeep.kaur36026@gmail.com
 */
@GlideModule
class ProjectAppGlideModule : AppGlideModule() {
    private val cacheSize  = (350*1024*1024).toLong()
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.setStyle(CircularProgressDrawable.LARGE)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        builder.setDefaultRequestOptions(
            RequestOptions()
                .placeholder(circularProgressDrawable)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        ).setDiskCache(InternalCacheDiskCacheFactory(context, cacheSize))
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}