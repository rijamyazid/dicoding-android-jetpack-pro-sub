package com.example.jetpack_submissions.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val movies = DataDummy.generateDummyMovies()
    private val tvshows = DataDummy.generateDummyTvshows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadMovieDetail() {
        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))

        Espresso.onView(withId(R.id.tv_detail_title_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_title_content))
            .check(matches(withText(movies[0].title)))

        Espresso.onView(withId(R.id.tv_year_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_year_content))
            .check(matches(withText(movies[0].releaseYear)))

        Espresso.onView(withId(R.id.tv_director_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_director_content))
            .check(matches(withText(movies[0].director)))

        Espresso.onView(withId(R.id.tv_country_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_country_content))
            .check(matches(withText(movies[0].country)))

        Espresso.onView(withId(R.id.rv_genres))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_genres)).check(matches(hasChildCount(movies[0].genre.size)))

        Espresso.onView(withId(R.id.tv_detail_description))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_description))
            .check(matches(withText(movies[0].desc)))
    }

    @Test
    fun loadTvshows() {
        Espresso.onView(withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tvshows))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_tvshows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvshows.size))
    }

    @Test
    fun loadTvshowsDetail(){
        Espresso.onView(withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))

        Espresso.onView(withId(R.id.tv_detail_title_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_title_content))
            .check(matches(withText(tvshows[0].title)))

        Espresso.onView(withId(R.id.tv_year_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_year_content))
            .check(matches(withText(tvshows[0].releaseYear)))

        Espresso.onView(withId(R.id.tv_director_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_director_content))
            .check(matches(withText(tvshows[0].director)))

        Espresso.onView(withId(R.id.tv_country_content))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_country_content))
            .check(matches(withText(tvshows[0].country)))

        Espresso.onView(withId(R.id.rv_genres))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rv_genres)).check(matches(hasChildCount(tvshows[0].genre.size)))

        Espresso.onView(withId(R.id.tv_detail_description))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_description))
            .check(matches(withText(tvshows[0].desc)))
    }
}