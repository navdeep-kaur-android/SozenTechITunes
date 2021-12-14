
package com.navdeepkaur.sozentechitunes.data.network

import com.navdeepkaur.sozentechitunes.data.local.DatabaseResults
import com.navdeepkaur.sozentechitunes.utils.getCurrencySymbol
import java.io.Serializable

/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
data class Movies(
   val resultCount: Int ,
    val results: List<Results>
    )
data class Results(
    val country: String?,
    val previewUrl: String?,
    val trackName: String?,
    val currency: String?,
    val kind: String?,
    val trackId: String?,
    val primaryGenreName: String?,
    val trackPrice: String?,
    val trackCensoredName: String?,
    val artistName: String?,
    val trackRentalPrice: String?,
    val longDescription: String?,
val artworkUrl100:String?

    ) : Serializable{
    val formattedRentalPrice: String
        get() {
            return "${this.currency?.getCurrencySymbol()} ${this.trackRentalPrice}"
        }
    val formattedPurchasePrice: String
        get() {
            return "${this.currency?.getCurrencySymbol()} ${this.trackPrice}"
        }
    }
fun List<Results>.asDatabaseModel(): List<DatabaseResults> {
    return map {
        DatabaseResults(
            country = it.country,
            previewUrl = it.previewUrl,
            trackName=  it.trackName,
            currency= it.currency,
            kind=  it.kind,
            trackId= it.trackId,
            primaryGenreName =  it.primaryGenreName,
            trackPrice=  it.trackPrice,
            trackCensoredName=  it.trackCensoredName,
            artistName=   it.artistName,
            trackRentalPrice=   it.trackRentalPrice,
            longDescription =  it.longDescription,
            artworkUrl100= it.artworkUrl100
        )
    }
}
