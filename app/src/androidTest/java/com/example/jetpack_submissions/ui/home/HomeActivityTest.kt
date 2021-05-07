package com.example.jetpack_submissions.ui.home

class HomeActivityTest {
//    private val movies = DataDummy.generateRemoteDummyMovies()
//    private val tvshows = DataDummy.generateRemoteDummyTVShows()
//
//    @get:Rule
//    var activityRule = ActivityScenarioRule(HomeActivity::class.java)
//
//    @Before
//    fun setUp() {
//        ActivityScenario.launch(HomeActivity::class.java)
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
//    }
//
//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
//    }
//
//    @Test
//    fun loadMovies() {
//        Espresso.onView(withId(R.id.rv_movies))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.rv_movies))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
//    }
//
//    @Test
//    fun loadMovieDetail() {
//        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
//            ViewActions.click()
//        ))
//
//        Espresso.onView(withId(R.id.tv_title_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_title_content))
//            .check(matches(withText(movies[0].title)))
//
//        Espresso.onView(withId(R.id.tv_year_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_year_content))
//            .check(matches(withText("Release date: "+movies[0].releaseDate)))
//
//        Espresso.onView(withId(R.id.tv_director_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_director_content))
//            .check(matches(withText(movies[0].director)))
//
//        Espresso.onView(withId(R.id.tv_country_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_country_content))
//            .check(matches(withText(movies[0].country)))
//
//        Espresso.onView(withId(R.id.rv_genres))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.rv_genres)).check(matches(hasChildCount(movies[0].genre.size)))
//
//        Espresso.onView(withId(R.id.tv_detail_description))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_description))
//            .check(matches(withText(movies[0].desc)))
//    }
//
//    @Test
//    fun loadTvshows() {
//        Espresso.onView(withText("TV Shows")).perform(ViewActions.click())
//        Espresso.onView(withId(R.id.rv_tvshows))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.rv_tvshows))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvshows.size))
//    }
//
//    @Test
//    fun loadTvshowsDetail(){
//        Espresso.onView(withText("TV Shows")).perform(ViewActions.click())
//        Espresso.onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
//            ViewActions.click()
//        ))
//
//        Espresso.onView(withId(R.id.tv_detail_title_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_title_content))
//            .check(matches(withText(tvshows[0].title)))
//
//        Espresso.onView(withId(R.id.tv_year_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_year_content))
//            .check(matches(withText(tvshows[0].releaseYear)))
//
//        Espresso.onView(withId(R.id.tv_director_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_director_content))
//            .check(matches(withText(tvshows[0].director)))
//
//        Espresso.onView(withId(R.id.tv_country_content))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_country_content))
//            .check(matches(withText(tvshows[0].country)))
//
//        Espresso.onView(withId(R.id.rv_genres))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.rv_genres)).check(matches(hasChildCount(tvshows[0].genre.size)))
//
//        Espresso.onView(withId(R.id.tv_detail_description))
//            .check(matches(isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_description))
//            .check(matches(withText(tvshows[0].desc)))
//    }
}