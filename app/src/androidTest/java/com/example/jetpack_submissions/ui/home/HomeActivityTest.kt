package com.example.jetpack_submissions.ui.home

import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.utils.DataDummy
import com.example.jetpack_submissions.utils.EspressoIdlingResource
import com.example.jetpack_submissions.utils.Helpers
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val movies = DataDummy.generateRemoteDummyMovies()
    private val tvshows = DataDummy.generateRemoteDummyTVShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size)
        )
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.tv_title_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_content)).check(matches(withText(movies[0].title)))

        onView(withId(R.id.tv_year_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_content)).check(
            matches(withText("Release date: " + Helpers.inverseDate(movies[0].releaseDate)))
        )

        onView(withId(R.id.tv_popularity_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity_content)).check(matches(withText(movies[0].popularity.toString())))

        onView(withId(R.id.tv_vote_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_content)).check(
            matches(withText(movies[0].voteAverage.toString() + "/10"))
        )

        onView(withId(R.id.rv_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_genres)).check(matches(hasChildCount(movies[0].genreIds.size)))

        onView(withId(R.id.tv_detail_description)).perform(betterScrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_description)).perform(betterScrollTo())
            .check(matches(withText(movies[0].overview)))
    }

    @Test
    fun loadTvshows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvshows.size)
        )
    }

    @Test
    fun loadTvshowsDetail() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )

        onView(withId(R.id.tv_title_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_content2)).check(matches(withText(tvshows[0].name)))

        onView(withId(R.id.tv_year_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_content2)).check(
            matches(withText("Release date: " + Helpers.inverseDate(tvshows[0].firstAirDate)))
        )

        onView(withId(R.id.tv_popularity_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity_content2)).check(matches(withText(tvshows[0].popularity.toString())))

        onView(withId(R.id.tv_vote_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_content2)).check(
            matches(withText(tvshows[0].voteAverage.toString() + "/10"))
        )

        onView(withId(R.id.rv_genres2)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_genres2)).check(matches(hasChildCount(tvshows[0].genreIds.size)))

        onView(withId(R.id.tv_detail_description2)).perform(betterScrollTo())
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_description2)).perform(betterScrollTo()).check(
            matches(withText(tvshows[0].overview))
        )
    }

    @Test
    fun loadFavoriteMovies() {

        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.appbar_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(
            allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bnv_main)),
                isDisplayed()
            )
        )
            .perform(click())

        onView(withId(R.id.rv_movies2)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies2)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_content)).check(matches(withText(movies[0].title)))
        onView(withId(R.id.tv_year_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_content)).check(
            matches(withText("Release date: " + Helpers.inverseDate(movies[0].releaseDate)))
        )

        onView(withId(R.id.appbar_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTVShows() {

        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.appbar_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(
            allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bnv_main)),
                isDisplayed()
            )
        )
            .perform(click())

        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tvshows2)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows2)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_content2)).check(matches(withText(tvshows[0].name)))
        onView(withId(R.id.tv_year_content2)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_content2)).check(
            matches(withText("Release date: " + Helpers.inverseDate(tvshows[0].firstAirDate)))
        )

        onView(withId(R.id.appbar_add_to_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

    }

    class BetterScrollToAction : ViewAction by ScrollToAction() {
        override fun getConstraints(): Matcher<View> {
            return allOf(
                withEffectiveVisibility(Visibility.VISIBLE),
                isDescendantOfA(
                    anyOf(
                        isAssignableFrom(ScrollView::class.java),
                        isAssignableFrom(HorizontalScrollView::class.java),
                        isAssignableFrom(NestedScrollView::class.java)
                    )
                )
            )
        }
    }

    private fun betterScrollTo(): ViewAction {
        return ViewActions.actionWithAssertions(BetterScrollToAction())
    }
}