package com.example.jetpack_submissions.utils

import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem

object DataDummy {

    fun generateRemoteDummyMovies(): ArrayList<MovieItem> {

        val listMovie = ArrayList<MovieItem>()

        listMovie.add(
            MovieItem(
                false,
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                listOf(14, 28, 12, 878, 53),
                460465,
                "en",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                4614.697,
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "2021-04-07",
                "Mortal Kombat",
                false,
                7.8,
                2079
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                listOf(878, 28, 18),
                399566,
                "en",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                2543.473,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                false,
                8.2,
                5255
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg",
                listOf(28, 80, 53),
                804435,
                "en",
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                2535.022,
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "2021-04-16",
                "Vanquish",
                false,
                6.0,
                51
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                listOf(28, 53, 80),
                615457,
                "en",
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                2265.723,
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "2021-03-26",
                "Nobody",
                false,
                8.5,
                1126
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
                listOf(16, 28, 12, 14, 18),
                635302,
                "ja",
                "劇場版「鬼滅の刃」無限列車編",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                1907.389,
                "/yF45egpHwaYLn4jTyZAgk0Cmug9.jpg",
                "2020-10-16",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                false,
                8.3,
                805
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                listOf(27),
                632357,
                "en",
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                1623.473,
                "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "2021-03-31",
                "The Unholy",
                false,
                5.7,
                66
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                listOf(28, 12, 14, 878),
                791373,
                "en",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                1601.059,
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                "Zack Snyder's Justice League",
                false,
                8.5,
                5291
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg",
                listOf(16, 35, 10751, 12),
                726684,
                "fr",
                "Miraculous World Shanghai, la légende de Ladydragon",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                1549.574,
                "/xt2EwFW5cxcmbDnVmH8izSftUtE.jpg",
                "2021-04-04",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                false,
                7.8,
                235
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                listOf(28, 12, 35, 14),
                615678,
                "en",
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                1513.876,
                "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "2021-04-09",
                "Thunder Force",
                false,
                5.8,
                510
            )
        )

        listMovie.add(
            MovieItem(
                false,
                "/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
                listOf(28, 53, 80),
                634528,
                "en",
                "The Marksman",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                1459.788,
                "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "2021-01-15",
                "The Marksman",
                false,
                7.5,
                352
            )
        )

        return listMovie

    }

    fun generateRemoteDummyTVShows(): ArrayList<TVShowItem> {

        val listMovie = ArrayList<TVShowItem>()

        listMovie.add(
            TVShowItem(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                listOf(10765, 10759, 18, 10768),
                88396,
                "The Falcon and the Winter Soldier",
                listOf("US"),
                "en",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                2008.626,
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5264
            )
        )

        listMovie.add(
            TVShowItem(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                listOf(16, 10759, 18, 10765),
                95557,
                "Invincible",
                listOf("US"),
                "en",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                1967.083,
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9,
                1237
            )
        )

        listMovie.add(
            TVShowItem(
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                listOf(18),
                71712,
                "The Good Doctor",
                listOf("US"),
                "en",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                1303.627,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                8.6,
                8256
            )
        )

        listMovie.add(
            TVShowItem(
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "2014-10-07",
                listOf(18, 10765),
                60735,
                "The Flash",
                listOf("US"),
                "en",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                1278.584,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7,
                7512
            )
        )

        listMovie.add(
            TVShowItem(
                "/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                "2018-04-22",
                listOf(18),
                79008,
                "Luis Miguel: The Series",
                listOf("MX"),
                "es",
                "Luis Miguel: La Serie",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                1003.741,
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                8.1,
                364
            )
        )

        listMovie.add(
            TVShowItem(
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                "2005-03-27",
                listOf(18),
                1416,
                "Grey's Anatomy",
                listOf("US"),
                "en",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                906.4,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                8.2,
                5971
            )
        )

        listMovie.add(
            TVShowItem(
                "/lEZLrd3N9nIk5fnCL30GsboCEmB.jpg",
                "2021-03-31",
                listOf(10764),
                120587,
                "Haunted: Latin America",
                listOf<String>(),
                "es",
                "Haunted: Latinoamérica",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                775.355,
                "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                7.5,
                201
            )
        )

        listMovie.add(
            TVShowItem(
                "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                "2016-01-25",
                listOf(80, 10765),
                63174,
                "Lucifer",
                listOf("US"),
                "en",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                779.561,
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5,
                8448
            )
        )

        listMovie.add(
            TVShowItem(
                "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                "2017-01-26",
                listOf(9648, 18, 80),
                69050,
                "Riverdale",
                listOf("US"),
                "en",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                758.299,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6,
                11159
            )
        )

        listMovie.add(
            TVShowItem(
                "/5VltHQJXdmbSD6gEJw3R8R1Kbmc.jpg",
                "2016-09-23",
                listOf(9648, 10765, 10759),
                65820,
                "Van Helsing",
                listOf("US"),
                "en",
                "Van Helsing",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                707.051,
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                6.9,
                533
            )
        )

        return listMovie

    }

    fun generateDummyMovies(): ArrayList<MovieEntity> {

        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
                false,
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                listOf("14", "28", "12", "878", "53"),
                "460465",
                "en",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "4614.697",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "2021-04-07",
                "Mortal Kombat",
                false,
                "7.8",
                "2079",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                listOf("878", "28", "18"),
                "399566",
                "en",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "2543.473",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                false,
                "8.2",
                "5255",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg",
                listOf("28", "80", "53"),
                "804435",
                "en",
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "2535.022",
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "2021-04-16",
                "Vanquish",
                false,
                "6.0",
                "51",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                listOf("28", "53", "80"),
                "615457",
                "en",
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "2265.723",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "2021-03-26",
                "Nobody",
                false,
                "8.5",
                "1126",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
                listOf("16", "28", "12", "14", "18"),
                "635302",
                "ja",
                "劇場版「鬼滅の刃」無限列車編",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "1907.389",
                "/yF45egpHwaYLn4jTyZAgk0Cmug9.jpg",
                "2020-10-16",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                false,
                "8.3",
                "805",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                listOf("27"),
                "632357",
                "en",
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "1623.473",
                "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "2021-03-31",
                "The Unholy",
                false,
                "5.7",
                "66"
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                listOf("28", "12", "14", "878"),
                "791373",
                "en",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "1601.059",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                "Zack Snyder's Justice League",
                false,
                "8.5",
                "5291",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg",
                listOf("16", "35", "10751", "12"),
                "726684",
                "fr",
                "Miraculous World Shanghai, la légende de Ladydragon",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "1549.574",
                "/xt2EwFW5cxcmbDnVmH8izSftUtE.jpg",
                "2021-04-04",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                false,
                "7.8",
                "235",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                listOf("28", "12", "35", "14"),
                "615678",
                "en",
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "1513.876",
                "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "2021-04-09",
                "Thunder Force",
                false,
                "5.8",
                "510",
                false
            )
        )
        listMovie.add(
            MovieEntity(
                false,
                "/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
                listOf("28", "53", "80"),
                "634528",
                "en",
                "The Marksman",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "1459.788",
                "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "2021-01-15",
                "The Marksman",
                false,
                "7.5",
                "352",
                false
            )
        )

        return listMovie
    }

    fun generateDummyTvshows(): ArrayList<TVShowEntity> {

        val listTvshow = ArrayList<TVShowEntity>()

        listTvshow.add(
            TVShowEntity(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                listOf("10765", "10759", "18", "10768"),
                "88396",
                "The Falcon and the Winter Soldier",
                listOf("US"),
                "en",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2008.626",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "7.9",
                "5264",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "2021-03-26",
                listOf("16", "10759", "18", "10765"),
                "95557",
                "Invincible",
                listOf("US"),
                "en",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "1967.083",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "8.9",
                "1237",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "2017-09-25",
                listOf("18"),
                "71712",
                "The Good Doctor",
                listOf("US"),
                "en",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "1303.627",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "8.6",
                "8256",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "2014-10-07",
                listOf("18", "10765"),
                "60735",
                "The Flash",
                listOf("US"),
                "en",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "1278.584",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "7.7",
                "7512",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                "2018-04-22",
                listOf("18"),
                "79008",
                "Luis Miguel: The Series",
                listOf("MX"),
                "es",
                "Luis Miguel: La Serie",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "1003.741",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "8.1",
                "364",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                "2005-03-27",
                listOf("18"),
                "1416",
                "Grey's Anatomy",
                listOf("US"),
                "en",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "906.4",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "8.2",
                "5971",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/lEZLrd3N9nIk5fnCL30GsboCEmB.jpg",
                "2021-03-31",
                listOf("10764"),
                "120587",
                "Haunted: Latin America",
                listOf<String>(),
                "es",
                "Haunted: Latinoamérica",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "775.355",
                "/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                "7.5",
                "201",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                "2016-01-25",
                listOf("80", "10765"),
                "63174",
                "Lucifer",
                listOf("US"),
                "en",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "779.561",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "8.5",
                "8448",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                "2017-01-26",
                listOf("9648", "18", "80"),
                "69050",
                "Riverdale",
                listOf("US"),
                "en",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "758.299",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "8.6",
                "11159",
                false
            )
        )
        listTvshow.add(
            TVShowEntity(
                "/5VltHQJXdmbSD6gEJw3R8R1Kbmc.jpg",
                "2016-09-23",
                listOf("9648", "10765", "10759"),
                "65820",
                "Van Helsing",
                listOf("US"),
                "en",
                "Van Helsing",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "707.051",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "6.9",
                "533",
                false
            )
        )

        return listTvshow
    }
}