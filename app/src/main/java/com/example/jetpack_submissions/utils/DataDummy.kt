package com.example.jetpack_submissions.utils

import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.data.TvshowEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {

        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
            "m1",
            "Alita: Battle Angel",
            "Robert Rodriguez",
            "United States",
            "2019",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                    listOf("Action", "Science Fiction", "Adventure"),
            R.drawable.poster_alita
        ))
        listMovie.add(
            MovieEntity(
            "m2",
            "Aquaman",
            "James Wan",
            "United States",
            "2018",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                    listOf("Action", "Adventure", "Fantasy"),
                    R.drawable.poster_aquaman
        ))
        listMovie.add(
            MovieEntity(
            "m3",
            "Cold Pursuit",
            "Hans Petter Moland",
            "United States",
            "2019",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                    listOf("Action", "Crime", "Thriller"),
                    R.drawable.poster_cold_persuit
        ))
        listMovie.add(
            MovieEntity(
            "m4",
            "Creed II",
            "Steven Caple Jr.",
            "United States",
            "2018",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                    listOf("Drama"),
                    R.drawable.poster_creed
        ))
        listMovie.add(
            MovieEntity(
            "m5",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "David Yates",
            "United States",
            "2018",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                    listOf("Adventure", "Fantasy", "Drama"),
                    R.drawable.poster_crimes
        ))
        listMovie.add(
            MovieEntity(
            "m6",
            "Glass",
            "M. Night Shyamalan",
            "United States",
            "2019",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                    listOf("Thriller", "Drama", "Science Fiction"),
                    R.drawable.poster_glass
        ))
        listMovie.add(
            MovieEntity(
            "m7",
            "How to Train Your Dragon: The Hidden World",
            "Dean DeBlois",
            "United States",
            "2019",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                    listOf("Animation", "Family", "Adventure"),
                    R.drawable.poster_how_to_train
        ))
        listMovie.add(
            MovieEntity(
            "m8",
            "Avengers: Infinity War",
            "Anthony Russo",
            "United States",
            "2018",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                    listOf("Adventure", "Action", "Science Fiction"),
                    R.drawable.poster_infinity_war
        ))
        listMovie.add(
            MovieEntity(
            "m9",
            "Mortal Engines",
            "Christian Rivers",
            "United States",
            "2018",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                    listOf("Adventure", "Science Fiction"),
                    R.drawable.poster_mortal_engines
        ))
        listMovie.add(
            MovieEntity(
            "m10",
            "Spider-Man: Into the Spider-Verse",
            "Rodney Rothman",
            "United States",
            "2018",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                    listOf("Action", "Adventure", "Animation", "Science Fiction", "Comedy"),
                    R.drawable.poster_spiderman
        ))

        return listMovie
    }

    fun generateDummyTvshows(): ArrayList<TvshowEntity> {

        val listTvshow = ArrayList<TvshowEntity>()

        listTvshow.add(
            TvshowEntity(
            "t1",
            "7 (Seven)",
            "Nizar Shafi",
            "India",
            "2019",
            "Multiple women report their husbands as missing but when it appears they are looking for the same man, a police officer traces their cryptic connection.",
            "https://upload.wikimedia.org/wikipedia/en/b/bb/Seven_Tv_Drama.png"
        ))
        listTvshow.add(TvshowEntity(
            "t2",
            "A Lion in the House",
            "Steven Bognar, Julia Reichert",
            "United States",
            "2006",
            "Five kids and their resilient families navigate the treatments and traumas of pediatric cancer in this documentary filmed over the course of six years.",
            "https://upload.wikimedia.org/wikipedia/en/2/29/A_Lion_in_the_House_-_cover_art.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t3",
            "13 Reasons Why",
            "Joseph Incaprera",
            "United States",
            "2020",
            "After a teenage girl's perplexing suicide, a classmate receives a series of tapes that unravel the mystery of her tragic choice.",
            "https://m.media-amazon.com/images/P/0451478290.01._SCLZZZZZZZ_SX500_.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t4",
            "A Young Doctor's Notebook and Other Stories",
            "Daniel Radcliffe",
            "United Kingdom",
            "2013",
            "Set during the Russian Revolution, this comic miniseries is based on a doctor's memories of his early career working in an out-of-the-way village.",
            "https://upload.wikimedia.org/wikipedia/en/9/95/Young-Doctors-Notebook-DVD.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t5",
            "A.I.C.O.",
            "Kazuya Murata",
            "Japan",
            "2018",
            "Everything Aiko knew was a lie. Now she's joining a team of Divers to reach the place where the Burst began to stop it for good and save her family.",
            "https://upload.wikimedia.org/wikipedia/en/9/92/A.I.C.O._-Incarnation-_poster.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t6",
            "Abby Hatcher",
            "Kyran Kelly",
            "United States",
            "2019",
            "A big-hearted girl helps her Fuzzly friends who live in her family's hotel with exploring feelings, fixing mishaps and embracing their special quirks.",
            "https://upload.wikimedia.org/wikipedia/en/e/e0/Abby_Hatcher_logo.png"
        ))
        listTvshow.add(TvshowEntity(
            "t7",
            "Absurd Planet",
            "Juliana Vicente",
            "United States",
            "2020",
            "A cast of quirky critters and Mother Nature herself narrate this funny science series, which peeks into the lives of Earth's most incredible animals.",
            "https://static.next-episode.net/tv-shows-images/huge/absurd-planet.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t8",
            "Age of Rebellion",
            "Peter Ho",
            "Taiwan",
            "2018",
            "At their high school, a group of unruly teens wreak havoc, face bullies and navigate turbulent lives beyond school grounds.",
            "https://i.mydramalist.com/8pq2df.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t9",
            "American Experience: The Circus",
            "Sharon Grimberg",
            "United States",
            "2018",
            "An exploration of the American circus, as the spectacle evolved from a one-ring show to a cultural event and eventually, a dying breed.",
            "https://images-na.ssl-images-amazon.com/images/I/81THLiNlSWL._SX268_.jpg"
        ))
        listTvshow.add(TvshowEntity(
            "t10",
            "Bring It On, Ghost",
            "Park Joon-hwa",
            "South Korea",
            "2016",
            "A college student with psychic abilities takes in an amnesiac ghost as his roommate who ends up helping him hunt down spooky spirits.",
            "https://asianwiki.com/images/e/e4/Let%27s_Fight_Ghost-p1.jpg"
        ))

        return listTvshow
    }
}