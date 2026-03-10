package com.flimix.poc.core.home

import com.flimix.poc.schema.PageResponse
import com.flimix.poc.schema.SchemaJson
import kotlinx.serialization.decodeFromString

object MockHomeRepository {

    private const val MOCK_RESPONSE = """
    {
      "title": "Home",
      "slug": "home",
      "schema": {
        "theme": "dark",
        "title": "Home",
  "blocks": [
    {
      "id": "block-a4a6s4j",
      "type": "hero",
      "props": {
        "items": [
          {
            "id": 7,
            "url": "/movies/7/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/126ab680263c47568dbbf8179675b98c.webp",
            "title": "Stranger Things",
            "genres": [
              "Scifi",
              "Horror"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/126ab680263c47568dbbf8179675b98c.webp",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": 2016
            },
            "subtitle": "In a small town in the 1980s, a group of kids uncovers secret experiments, terrifying creatures, and a mysterious girl with incredible powers.",
            "show_meta": true,
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/126ab680263c47568dbbf8179675b98c.webp",
            "content_id": 7,
            "cover_path": "uploads/other/7ab39cb410744e17a9db16f25787c477.webp",
            "show_title": true,
            "title_type": "text",
            "poster_path": "uploads/image/bf367b199e0f40bca1b1079e4564a095.png",
            "primary_cta": {
              "icon": "Play",
              "link": "/movies/7/",
              "size": "medium",
              "label": "Watch Now",
              "variant": "solid",
              "text_color": "#000000",
              "border_radius": "md",
              "icon_position": "left",
              "icon_thickness": "normal",
              "background_color": "#ffffff"
            },
            "show_genres": true,
            "show_hashtag": true,
            "show_subtitle": true,
            "thumbnail_path": "uploads/other/db5802f817f24495867e8b76dc2f7f63.webp"
          },
          {
            "id": 1,
            "url": "/movies/1/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "title": "Interstellar 2",
            "genres": [
              "Scifi",
              "Adventure"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": 2014
            },
            "subtitle": "With Earth on the brink of collapse, a team of explorers travels through a wormhole in search of a new home for humanity.",
            "show_meta": true,
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "content_id": 1,
            "cover_path": "uploads/other/12db8bb381bf408fb6ed9702b74177a3.webp",
            "show_title": true,
            "title_type": "text",
            "poster_path": "uploads/image/83931c83f164465fa67a5ea99adf14da.png",
            "primary_cta": {
              "icon": "Play",
              "link": "/movies/1/",
              "size": "medium",
              "label": "Watch Now",
              "variant": "solid",
              "text_color": "#000000",
              "border_radius": "md",
              "icon_position": "left",
              "icon_thickness": "normal",
              "background_color": "#ffffff"
            },
            "show_genres": true,
            "show_hashtag": true,
            "show_subtitle": true,
            "thumbnail_path": "uploads/other/363d6b4ccc984cd28187f89caf47d318.webp"
          },
          {
            "id": 6,
            "url": "/movies/6/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "title": "Inception",
            "genres": [
              "Thirller",
              "Scifi"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "status": "Published",
            "details": {
              "duration": "00:02:51",
              "imdb_rating": null,
              "release_year": 2010
            },
            "subtitle": "A skilled thief who steals secrets through dreams is offered a chance at redemption if he can successfully plant an idea inside a target's mind.",
            "show_meta": true,
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "content_id": 6,
            "cover_path": "uploads/image/bf8a41f94b52441cb98333580b5c9567.jpg",
            "show_title": true,
            "title_type": "text",
            "poster_path": "uploads/other/7436c38703a84a97ba7c8632d9783e5d.webp",
            "primary_cta": {
              "icon": "Play",
              "link": "/movies/6/",
              "size": "medium",
              "label": "Watch Now",
              "variant": "solid",
              "text_color": "#000000",
              "border_radius": "md",
              "icon_position": "left",
              "icon_thickness": "normal",
              "background_color": "#ffffff"
            },
            "show_genres": true,
            "show_hashtag": true,
            "show_subtitle": true,
            "thumbnail_path": "uploads/other/7436c38703a84a97ba7c8632d9783e5d.webp"
          }
        ],
        "variant": "carousel",
        "autoplay": false,
        "show_arrows": true,
        "aspect_ratio": "custom",
        "scroll_speed": 5000,
        "custom_height": "660px"
      },
      "style": {
        "text_align": "left",
        "padding_top": "10px",
        "padding_left": "10px",
        "margin_bottom": "px",
        "padding_right": "10px",
        "padding_bottom": "10px",
        "background_color": "transparent"
      }
    },
    {
      "id": "block-ygms2og",
      "type": "carousel",
      "props": {
        "items": [
          {
            "id": 1,
            "url": "/movies/1/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "title": "Interstellar 2",
            "genres": [
              "Scifi",
              "Adventure"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": 2014
            },
            "progress": 0,
            "subtitle": "With Earth on the brink of collapse, a team of explorers travels through a wormhole in search of a new home for humanity.",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/bf2445d7a62a48db878045686d414a69.webp",
            "content_id": 1,
            "cover_path": "uploads/other/12db8bb381bf408fb6ed9702b74177a3.webp",
            "poster_path": "uploads/image/83931c83f164465fa67a5ea99adf14da.png",
            "thumbnail_path": "uploads/other/363d6b4ccc984cd28187f89caf47d318.webp"
          },
          {
            "id": 10,
            "url": "/movies/10/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/1287c88a9cab485a92f539eb1c67a89f.jpg",
            "title": "Game Changer",
            "genres": [],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/1287c88a9cab485a92f539eb1c67a89f.jpg",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": null
            },
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/1287c88a9cab485a92f539eb1c67a89f.jpg",
            "content_id": 10,
            "cover_path": "uploads/image/ab8d4f476ed848f4a28059c5f8a2c1e6.jpg",
            "poster_path": "uploads/image/93978a0b58984f60a3d69b803ac02ee8.png",
            "thumbnail_path": "uploads/image/93978a0b58984f60a3d69b803ac02ee8.png"
          },
          {
            "id": 4,
            "url": "/movies/4/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/9b665f784b0a47639f6374db3b7ea3fd.jpg",
            "title": "Aavesham 2",
            "genres": [
              "Drama"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/9b665f784b0a47639f6374db3b7ea3fd.jpg",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": 2023
            },
            "progress": 0,
            "subtitle": "Drama description",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/9b665f784b0a47639f6374db3b7ea3fd.jpg",
            "content_id": 4,
            "cover_path": "uploads/image/07ad7b73ca9a4c8e9fe1ce280aac0e29.jpg",
            "poster_path": "uploads/image/9b665f784b0a47639f6374db3b7ea3fd.jpg",
            "thumbnail_path": "uploads/image/0a8e56b02f414ea780e81bba636eae20.jpg"
          },
          {
            "id": 7,
            "url": "/movies/7/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/d2beb297c17d42169edb02a126258497.jpeg",
            "title": "Stranger Things",
            "genres": [
              "Scifi",
              "Horror"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/d2beb297c17d42169edb02a126258497.jpeg",
            "status": "Published",
            "details": {
              "duration": "00:00:31",
              "imdb_rating": null,
              "release_year": 2016
            },
            "progress": 0,
            "subtitle": "In a small town in the 1980s, a group of kids uncovers secret experiments, terrifying creatures, and a mysterious girl with incredible powers.",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/d2beb297c17d42169edb02a126258497.jpeg",
            "content_id": 7,
            "cover_path": "uploads/other/7ab39cb410744e17a9db16f25787c477.webp",
            "poster_path": "uploads/image/bf367b199e0f40bca1b1079e4564a095.png",
            "thumbnail_path": "uploads/other/db5802f817f24495867e8b76dc2f7f63.webp"
          },
          {
            "id": 6,
            "url": "/movies/6/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "title": "Inception",
            "genres": [
              "Thirller",
              "Scifi"
            ],
            "poster": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "status": "Published",
            "details": {
              "duration": "00:02:51",
              "imdb_rating": null,
              "release_year": 2010
            },
            "progress": 0,
            "subtitle": "A skilled thief who steals secrets through dreams is offered a chance at redemption if he can successfully plant an idea inside a target's mind.",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/17d6a2eba96e45b7b1a4ce6e723dca59.jpg",
            "content_id": 6,
            "cover_path": "uploads/image/bf8a41f94b52441cb98333580b5c9567.jpg",
            "poster_path": "uploads/other/7436c38703a84a97ba7c8632d9783e5d.webp",
            "thumbnail_path": "uploads/other/7436c38703a84a97ba7c8632d9783e5d.webp"
          },
          {
            "id": 8,
            "url": "/movies/8/",
            "type": "Movie",
            "cover": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/b77237e4c6b640fcaced8d702bbc3db8.png",
            "title": "Varisu",
            "genres": [
              "Drama"
            ],
            "poster": null,
            "status": "Published",
            "details": {
              "duration": "00:00:14",
              "imdb_rating": null,
              "release_year": 2002
            },
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/b77237e4c6b640fcaced8d702bbc3db8.png",
            "content_id": 8,
            "cover_path": "uploads/image/474a469289ec4e5f8cedeaa7afe72245.png",
            "poster_path": null,
            "thumbnail_path": "uploads/image/4cbe74888a0247689827360b0d0ab37f.png"
          }
        ],
        "title": "Trending Now",
        "button": {
          "icon": "ArrowRight",
          "link": "",
          "text": "View All",
          "enabled": false,
          "alignment": "right",
          "text_color": "#ffffff",
          "icon_position": "right"
        },
        "autoplay": false,
        "alignment": "left",
        "item_size": "small",
        "item_shape": "rectangle-landscape",
        "show_genre": false,
        "show_title": true,
        "show_arrows": true,
        "show_rating": true,
        "scroll_speed": 1000,
        "show_duration": true,
        "show_subtitle": false
      },
      "style": {
        "grid_gap": "sm",
        "text_align": "left",
        "padding_top": "px",
        "padding_left": "px",
        "padding_right": "px",
        "padding_bottom": "10px"
      }
    },
    {
      "id": "block-9q4yiy0",
      "type": "carousel",
      "props": {
        "items": [
          {
            "id": 32,
            "url": "/book/32/",
            "type": "Book",
            "cover": null,
            "title": "Top Gun",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/a89aab8ce7804b2fb570cb44a5cc0f2b.webp",
            "content_id": 32,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/0781620ca222432c818d2cba709ed719.webp"
          },
          {
            "id": 12,
            "url": "/book/12/",
            "type": "Book",
            "cover": null,
            "title": "Avatar",
            "genres": [
              "fsda"
            ],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/111bbddad14d4ddbb9cb96c5d8b42edf.webp",
            "content_id": 12,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/d974b8178f2b4096b1aee00dd750949f.webp"
          },
          {
            "id": 17,
            "url": "/book/17/",
            "type": "Book",
            "cover": null,
            "title": "Oppenheimer",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/99a3a96ee65947edbc15c6a786a921f4.webp",
            "content_id": 17,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/2e1922aecabc42bea546fad3a0218548.webp"
          },
          {
            "id": 27,
            "url": "/book/27/",
            "type": "Book",
            "cover": null,
            "title": "Barbie",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/edb7a8f14c66426eb04c5b8d031e55e7.webp",
            "content_id": 27,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/edb7a8f14c66426eb04c5b8d031e55e7.webp"
          },
          {
            "id": 28,
            "url": "/book/28/",
            "type": "Book",
            "cover": null,
            "title": "Dune",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/c4a65cd073ea44acb085bc4cc2482d1e.webp",
            "content_id": 28,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/f7d8bf7b370b4ab786f619e6134c28bf.webp"
          },
          {
            "id": 29,
            "url": "/book/29/",
            "type": "Book",
            "cover": null,
            "title": "Batman",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/ad12054c347d4ee0a1f26515451dedba.webp",
            "content_id": 29,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/0b4860fdf49d4ceb8b33c7e0bc875c05.webp"
          },
          {
            "id": 30,
            "url": "/book/30/",
            "type": "Book",
            "cover": null,
            "title": "Joker",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/190fb891af154767b6b2f4deab035052.webp",
            "content_id": 30,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/f45421e6dafd42578c80219455bfa45f.webp"
          },
          {
            "id": 31,
            "url": "/book/31/",
            "type": "Book",
            "cover": null,
            "title": "Avengers",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/other/3246905219184920b23d032b552486cb.webp",
            "content_id": 31,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/other/9a7959f0244b4461bc4f961dfdb5961b.webp"
          }
        ],
        "title": "Books Ratio",
        "autoplay": false,
        "alignment": "left",
        "item_size": "small",
        "item_shape": "rectangle-portrait",
        "show_genre": false,
        "show_title": false,
        "show_arrows": true,
        "show_rating": true,
        "progress_bar": {
          "color": "#ff0000",
          "enabled": false
        },
        "scroll_speed": 1000,
        "show_duration": true,
        "show_subtitle": false
      },
      "style": {
        "grid_gap": "sm",
        "text_align": "left",
        "padding_top": "px",
        "padding_left": "px",
        "padding_right": "px",
        "padding_bottom": "px",
        "background_color": "rgba(255, 255, 255, 0)"
      }
    },
    {
      "id": "block-pgc0yco",
      "type": "carousel",
      "props": {
        "items": [
          {
            "id": 15,
            "url": "/podcast/15/",
            "type": "Podcast",
            "cover": null,
            "title": "Tech Talk Daily",
            "genres": [
              "podcast"
            ],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/5c811ac620b54bca93495576a786dc29.jpeg",
            "content_id": 15,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/7a35a0021f7a44528cb54e23218062a5.jpeg"
          },
          {
            "id": 23,
            "url": "/podcast/23/",
            "type": "Podcast",
            "cover": null,
            "title": "True Crime Files",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/f536ab1a3f88449eac09ab1841d07969.jpeg",
            "content_id": 23,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/c655ebec3c7f4ac2abcc89956bba840b.jpeg"
          },
          {
            "id": 20,
            "url": "/podcast/20/",
            "type": "Podcast",
            "cover": null,
            "title": "The Mindful Minute",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/c2ee4c4c3fdb4ff1a7a388c27c7d8186.jpeg",
            "content_id": 20,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/e8ffeae6b6d94646b76817439c62ca60.jpeg"
          },
          {
            "id": 21,
            "url": "/podcast/21/",
            "type": "Podcast",
            "cover": null,
            "title": "Startup Stories",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/d8504531fcdf4c15916d6a965f109be8.jpeg",
            "content_id": 21,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/f2127072b2124470ae378ed9cfeae8d2.jpeg"
          },
          {
            "id": 22,
            "url": "/podcast/22/",
            "type": "Podcast",
            "cover": null,
            "title": "Late Night Conversations",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/ef26e8089fb740218a1209af0c65bd22.jpeg",
            "content_id": 22,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/0a6f39d01e53477ebbe9f2f55f08f56e.jpeg"
          },
          {
            "id": 24,
            "url": "/podcast/24/",
            "type": "Podcast",
            "cover": null,
            "title": "Daily News Brief",
            "genres": [],
            "poster": null,
            "status": "Published",
            "details": {},
            "progress": 0,
            "subtitle": "",
            "thumbnail": "https://s3.eu-central-1.wasabisys.com/flimix.testpress.in/uploads/image/0dd0c5797bac42d8aa447152980aaff7.jpeg",
            "content_id": 24,
            "cover_path": null,
            "poster_path": null,
            "thumbnail_path": "uploads/image/c3923cf46ed64c988e8c710b9aeb9220.jpeg"
          }
        ],
        "title": "Podcast and Albums",
        "button": {
          "icon": "ArrowRight",
          "link": "",
          "text": "View All",
          "enabled": false,
          "alignment": "right",
          "text_color": "#ffffff",
          "icon_position": "right"
        },
        "autoplay": false,
        "alignment": "left",
        "item_size": "small",
        "item_shape": "square",
        "show_genre": false,
        "show_title": true,
        "show_arrows": true,
        "show_rating": true,
        "scroll_speed": 1000,
        "show_duration": true,
        "show_subtitle": true
      },
      "style": {
        "grid_gap": "sm",
        "text_align": "left",
        "padding_top": "px",
        "padding_left": "px",
        "padding_right": "px",
        "padding_bottom": "px"
      }
    }
  ],
  "layout": {
    "canvas_bg": "#171717",
    "canvas_content_width": 92
  },
  "visibility": {
    "platform": [
      "mobile",
      "desktop"
    ]
  }
      }
    }
    """

    fun getHomePage(): PageResponse = SchemaJson.json.decodeFromString(MOCK_RESPONSE)
}
