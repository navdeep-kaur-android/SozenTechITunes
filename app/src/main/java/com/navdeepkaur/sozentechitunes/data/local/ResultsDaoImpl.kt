package com.navdeepkaur.sozentechitunes.data.local

import android.util.Log
import io.realm.Realm

/**
 * Created by Navdeep Kaur on 12/12/2021
 * navdeep.kaur36026@gmail.com
 */
class ResultsDaoImpl : ResultsDao{
    override fun addMoviesLocally(results: List<DatabaseResults>): Boolean {
        return try {
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction{realm1 ->
                realm1.insertOrUpdate(results)
            }
            realm.close()
            true
        } catch (e: Exception) {
            Log.d("Adding Exception", e.message ?: "Exception while adding data Locally")
            false
        }
    }

    override fun retrieveLocalMovies(data : String): List<DatabaseResults> {
        val realm = Realm.getDefaultInstance()
        val list =  realm.copyFromRealm(realm.where(DatabaseResults::class.java)
            .contains("trackName", data)
            .findAll())
        realm.close()
        return list
    }
}