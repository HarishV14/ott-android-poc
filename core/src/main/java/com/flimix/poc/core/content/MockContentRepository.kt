package com.flimix.poc.core.content

object MockContentRepository : ContentRepository {
    private const val DEFAULT_PLAYBACK_URL =
        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/transcoded/23/video.m3u8"

    private val items: Map<Int, ContentDetail> =
        mapOf(
            7 to
                ContentDetail(
                    id = 7,
                    title = "Stranger Things",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/126ab680263c47568dbbf8179675b98c.webp",
                    description =
                        "In a small town in the 1980s, a group of kids uncovers secret experiments, terrifying creatures, and a mysterious girl with incredible powers.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            1 to
                ContentDetail(
                    id = 1,
                    title = "Interstellar 2",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
                    description =
                        "With Earth on the brink of collapse, a team of explorers travels through a wormhole in search of a new home for humanity.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            6 to
                ContentDetail(
                    id = 6,
                    title = "Inception",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
                    description =
                        "A skilled thief who steals secrets through dreams is offered a chance at redemption if he can successfully plant an idea inside a target's mind.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            10 to 
                ContentDetail(
                    id = 10,
                    title = "Game Changer",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/1287c88a9cab485a92f539eb1c67a89f.jpg",
                    description =
                        "A skilled thief who steals secrets through dreams is offered a chance at redemption if he can successfully plant an idea inside a target's mind.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            4 to 
                ContentDetail(
                    id = 4,
                    title = "Aavesham",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/9b665f784b0a47639f6374db3b7ea3fd.jpg",
                    description =
                        "A gangster in his late 30s, known for his volatile temper and extravagant lifestyle, takes a group of engineering students under his wing, leading to a series of chaotic and darkly comedic events.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            8 to 
                ContentDetail(
                    id = 8,
                    title = "Varisu",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/b77237e4c6b640fcaced8d702bbc3db8.png",
                    description =
                        "A gangster in his late 30s, known for his volatile temper and extravagant lifestyle, takes a group of engineering students under his wing, leading to a series of chaotic and darkly comedic events.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            32 to 
                ContentDetail(
                    id = 32,
                    title = "Top Gun",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/a89aab8ce7804b2fb570cb44a5cc0f2b.webp",
                    description =
                        "As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            12 to 
                ContentDetail(
                    id = 12,
                    title = "Avatar",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/111bbddad14d4ddbb9cb96c5d8b42edf.webp",
                    description =
                        "As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            17 to 
                ContentDetail(
                    id = 17,
                    title = "Oppenheimer",
                    coverUrl =
                        "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/99a3a96ee65947edbc15c6a786a921f4.webp",
                    description =
                        "As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl = DEFAULT_PLAYBACK_URL,
                ),
            27 to 
                ContentDetail(
                    id=27,
                    title="Barbie",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/edb7a8f14c66426eb04c5b8d031e55e7.webp",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            28 to 
                ContentDetail(
                    id=28,
                    title="Dune",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/c4a65cd073ea44acb085bc4cc2482d1e.webp",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            29 to 
                ContentDetail(
                    id=29,
                    title="Batman",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/ad12054c347d4ee0a1f26515451dedba.webp",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            30 to 
                ContentDetail(
                    id=30,
                    title="Joker",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/190fb891af154767b6b2f4deab035052.webp",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            31 to 
                ContentDetail(
                    id=31,
                    title="31",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/3246905219184920b23d032b552486cb.webp",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            15 to 
                ContentDetail(
                    id=15,
                    title="Tech Talk Daily",
                    coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/5c811ac620b54bca93495576a786dc29.jpeg",
                    description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                    playbackUrl=DEFAULT_PLAYBACK_URL,
                ),
            23 to ContentDetail(
                id=23,
                title="True Crime Files",
                coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/f536ab1a3f88449eac09ab1841d07969.jpeg",
                description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                playbackUrl=DEFAULT_PLAYBACK_URL,
            ),
            20 to ContentDetail(
                id=20,
                title="The Mindful Minute",
                coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/c2ee4c4c3fdb4ff1a7a388c27c7d8186.jpeg",
                description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                playbackUrl=DEFAULT_PLAYBACK_URL,
            ),
            21 to ContentDetail(
                id=21,
                title="Startup Stories",
                coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/ef26e8089fb740218a1209af0c65bd22.jpeg",
                description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                playbackUrl=DEFAULT_PLAYBACK_URL,
            ),
            24 to ContentDetail(
                id=24,
                title="Daily News Brief",
                coverUrl="https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/0dd0c5797bac42d8aa447152980aaff7.jpeg",
                description="As a Navy pilot, Maverick is one of the best, but his rebellious streak has cost him his wings. Now, he's back at Top Gun to train a new generation of fighter pilots, but he'll have to confront his past and his fears to succeed.",
                playbackUrl=DEFAULT_PLAYBACK_URL,
            ),
        )

    override fun getContentDetail(contentId: Int): ContentDetail? {
        return items[contentId]
            ?: ContentDetail(
                id = contentId,
                title = "Content #$contentId",
                coverUrl = null,
                description = null,
                playbackUrl = DEFAULT_PLAYBACK_URL,
            )
    }
}

