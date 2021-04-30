package com.example.jetpack_submissions.utils

import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.data.TvshowEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {

        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
            "m1",
            "(T)ERROR",
            "Lyric R. Cabral",
            "United States",
            "2015",
            "This real-life look at FBI counterterrorism operations features access to both sides of a sting: the government informant and the radicalized target.",
            "https://upload.wikimedia.org/wikipedia/en/0/04/%28T%29ERROR_poster.png"
        ))
        listMovie.add(
            MovieEntity(
            "m2",
            "1 Mile to You",
            "Leif Tilden",
            "United States",
            "2017",
            "After escaping the bus accident that killed his girlfriend, a high school student channels his grief into running, with the help of a new coach.",
            "https://upload.wikimedia.org/wikipedia/en/8/8b/1_Mile_to_You_poster.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m3",
            "10 Days in Sun City",
            "Adze Ugah",
            "Nigeria",
            "2017",
            "After his girlfriend wins the Miss Nigeria pageant, a young man faces unexpected competition of his own when he joins her on a campaign in South Africa.",
            "https://upload.wikimedia.org/wikipedia/en/3/31/This_is_a_cover_image_for_10_Days_in_Sun_City.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m4",
            "A Fall from Grace",
            "Tyler Perry",
            "United States",
            "2020",
            "When gentle, law-abiding Grace confesses to killing her new husband, her skeptical young lawyer sets out to uncover the truth. A film by Tyler Perry.",
            "https://upload.wikimedia.org/wikipedia/en/4/4e/AFallFromGrace.png"
        ))
        listMovie.add(
            MovieEntity(
            "m5",
            "A Family Man",
            "Mark Williams",
            "Canada",
            "2016",
            "A ruthless corporate headhunter battles his rival for a promotion while dealing with a family crisis that threatens to derail his career.",
            "https://upload.wikimedia.org/wikipedia/en/8/8b/A_Family_Man_poster.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m6",
            "Bodyguard",
            "Siddique",
            "India",
            "2011",
            "Irked by her bodyguard, an heiress invents a secret admirer to throw him off his duties, but the plan may backfire when she falls for him.",
            "https://upload.wikimedia.org/wikipedia/en/a/af/Bodyguard_poster.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m7",
            "Barbie Dolphin Magic",
            "Conrad Helten",
            "United States",
            "2017",
            "While visiting Ken and exploring a coral reef, Barbie and her sisters make an amazing discovery and meet a mysterious new friend.",
            "https://upload.wikimedia.org/wikipedia/en/7/7d/Bdolphmag.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m8",
            "Cahaya Dari Timur Beta Maluku",
            "Angga Dwimas Sasongko",
            "Indonesia",
            "2014",
            "After witnessing a child's death during a violent clash, a former soccer player launches a youth team to help local kids avoid further bloodshed.",
            "https://upload.wikimedia.org/wikipedia/id/f/f0/Poster_film_Cahaya_dari_Timur.jpg"
        ))
        listMovie.add(
            MovieEntity(
            "m9",
            "Christopher Robin",
            "Marc Forster",
            "United States",
            "2018",
            "Now a careworn middle-aged man, Christopher Robin goes on a familiar adventure when his old pal Winnie the Pooh brings him to the Hundred Acre Wood.",
            "https://upload.wikimedia.org/wikipedia/en/a/a9/Christopher_Robin_poster.png"
        ))
        listMovie.add(
            MovieEntity(
            "m10",
            "Dark Crimes",
            "Alexandros Avranas",
            "United Kingdom",
            "2016",
            "A detective on a cold murder case discovers that a famous writerâ€™s latest novel contains details chillingly similar to the crime heâ€™s investigating.",
            "https://upload.wikimedia.org/wikipedia/en/d/db/Dark_Crimes.png"
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