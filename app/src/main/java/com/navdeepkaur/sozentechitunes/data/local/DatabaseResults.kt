package com.navdeepkaur.sozentechitunes.data.local

import com.navdeepkaur.sozentechitunes.data.network.Results
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Navdeep Kaur on 12/13/2021
 * navdeep.kaur36026@gmail.com
 */
open class DatabaseResults(

    var country: String? = null,
    var previewUrl: String? = null,
    var trackName: String? = null,
    var currency: String? = null,
    var kind: String? = null,
    @PrimaryKey
    var trackId: String? = null,
    var primaryGenreName: String? = null,
    var trackPrice: String? = null,
    var trackCensoredName: String? = null,
    var artistName: String?= null,
    var trackRentalPrice: String?= null,
    var longDescription: String?= null,
    var artworkUrl100:String? = null
) : RealmObject() {
}
fun List<DatabaseResults>.asDomainModel(): List<Results> {
    return map {
        Results(
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