package com.navdeepkaur.sozentechitunes.movies

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.navdeepkaur.sozentechitunes.R
import com.navdeepkaur.sozentechitunes.data.FakeDataSource
import com.navdeepkaur.sozentechitunes.data.IDataSource
import com.navdeepkaur.sozentechitunes.util.atPosition
import com.navdeepkaur.sozentechitunes.util.createResultsList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.Mockito

/**
 * Created by Navdeep Kaur on 12/14/2021
 * navdeep.kaur36026@gmail.com
 */
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
//UI Testing
@MediumTest
class MoviesGridFragmentTest : KoinTest{

    //set fake view model to test fragment
    private val viewModelModule = module {
        val dataRepository = FakeDataSource(createResultsList())
       single {
            MoviesGridViewModel(
                get(),
                dataRepository as IDataSource
            )
        }

    }
    @Before
    fun setUp() {
        loadKoinModules(viewModelModule) }

    @Test
    fun matchData_DeviceList() = runBlockingTest {
        // GIVEN - On the Movies List Screen
        val scenario = launchFragmentInContainer<MoviesGridFragment>(Bundle(), R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }
        // Verify the loaded data
        Espresso.onView(withId(R.id.moviesRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("No Time to Die")))))

        Espresso.onView(withId(R.id.moviesRecyclerView))
            .check(matches(atPosition(1, hasDescendant(withText("Catch The Fire")))))
}
}