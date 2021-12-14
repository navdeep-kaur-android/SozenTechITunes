package com.navdeepkaur.sozentechitunes.util

import com.navdeepkaur.sozentechitunes.data.network.Results


/**
 * Created by Navdeep Kaur on 12/4/2021
 * navdeep.kaur36026@gmail.com
 */
fun createResultsList(): MutableList<Results> {

    val result = Results(
        country = "USA",
        previewUrl = "https://video-ssl.itunes.apple.com/itunes-assets/Video116/v4/b7/9f/b1/b79fb10e-738b-e2e3-f582-9deeafed21ff/mzvf_6822508294691609644.640x352.h264lc.U.p.m4v",
        trackName=  "No Time to Die",
        currency= "USD",
        kind=  "feature-movie",
        trackId= "1589483727",
        primaryGenreName =  "Action & Adventure",
        trackPrice=  "19.99",
        trackCensoredName=  "No Time to Die",
        artistName=   "Cary Joji Fukunaga",
        trackRentalPrice=   "9.9",
        longDescription =  "Daniel Craig returns one last time as James Bond",
        artworkUrl100="https://is4-ssl.mzstatic.com/image/thumb/Video113/v4/2c/75/fc/2c75fc0a-b2d9-1d15-8e4d-1022a98b261f/pr_source.lsr/100x100bb.jpg")
    val result2 = Results(
        country = "USA",
        previewUrl = "https://video-ssl.itunes.apple.com/itunes-assets/Video116/v4/b7/9f/b1/b79fb10e-738b-e2e3-f582-9deeafed21ff/mzvf_6822508294691609644.640x352.h264lc.U.p.m4v",
        trackName=  "Catch The Fire",
        currency= "CAD",
        kind=  "feature",
        trackId= "1589483727",
        primaryGenreName =  "Comedy",
        trackPrice=  "14",
        trackCensoredName=  "Catch The Fire",
        artistName=   "Cary Joji",
        trackRentalPrice=   "3.9",
        longDescription =  "Daniel Craig returns one last time as James",
        artworkUrl100="https://is4-ssl.mzstatic.com/image/thumb/Video113/v4/2c/75/fc/2c75fc0a-b2d9-1d15-8e4d-1022a98b261f/pr_source.lsr/100x100bb.jpg")

    return mutableListOf(result, result2)
}