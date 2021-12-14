package com.navdeepkaur.sozentechitunes

import android.app.Application
import com.navdeepkaur.sozentechitunes.data.IDataSource
import com.navdeepkaur.sozentechitunes.data.MoviesRepository
import com.navdeepkaur.sozentechitunes.data.local.ResultsDao
import com.navdeepkaur.sozentechitunes.data.local.ResultsDaoImpl
import com.navdeepkaur.sozentechitunes.data.network.IApiServices
import com.navdeepkaur.sozentechitunes.data.network.getApiService
import com.navdeepkaur.sozentechitunes.data.network.getMoshi
import com.navdeepkaur.sozentechitunes.movies.MoviesGridViewModel
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
class ItunesApp : Application() {
    val realmName: String = "SozenTech Itunes"
    override fun onCreate() {
        super.onCreate()
        initRealm()

        val modules =  module {

            factory { ResultsDaoImpl() as ResultsDao }
            single { getApiService(get()) as IApiServices }
            single { getMoshi() }
            single { MoviesRepository(get(), apiService = get())as IDataSource }
            viewModel{ MoviesGridViewModel(get(),get() as IDataSource) }

        }

        startKoin {
            androidContext(this@ItunesApp)
            modules(modules) }
    }

    private fun initRealm() {
        Realm.init(this@ItunesApp)
        val config = RealmConfiguration.Builder()
            .name("movies")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config);
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}