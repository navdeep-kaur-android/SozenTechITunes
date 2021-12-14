package com.navdeepkaur.sozentechitunes.data.network

import com.navdeepkaur.sozentechitunes.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
fun getMoshi(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

fun getClient() : OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor)
        .addInterceptor(Interceptor{
            val string = it.request().url.toString().replace("%20", "+")
            val newRequest: Request = Request.Builder()
                .url(string)
                .build()
          it.proceed(newRequest)
        }).build()
}



fun getApiService(moshi: Moshi) : IApiServices =
    Retrofit.Builder().run {
        client(getClient())
        addConverterFactory(MoshiConverterFactory.create(moshi))
        baseUrl(BuildConfig.BASE_URL)
        build().create(IApiServices::class.java)
    }