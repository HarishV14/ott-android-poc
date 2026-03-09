package com.flimix.poc.schema

import kotlinx.serialization.json.Json

object MockApi {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

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
                  "cover": "http://localhost:9000/flimix.flimix.co/uploads/other/7ab39cb410744e17a9db16f25787c477.webp",
                  "title": "Stranger Things",
                  "genres": ["Scifi", "Horror"],
                  "poster": "http://localhost:9000/flimix.flimix.co/uploads/image/bf367b199e0f40bca1b1079e4564a095.png",
                  "status": "Published",
                  "details": {"duration": "00:00:31", "imdb_rating": null, "release_year": 2016},
                  "subtitle": "In a small town in the 1980s, a group of kids uncovers secret experiments, terrifying creatures, and a mysterious girl with incredible powers.",
                  "show_meta": true,
                  "thumbnail": "http://localhost:9000/flimix.flimix.co/uploads/other/db5802f817f24495867e8b76dc2f7f63.webp",
                  "content_id": 7,
                  "primary_cta": {
                    "icon": "Play",
                    "link": "/movies/7/",
                    "label": "Watch Now",
                    "variant": "solid",
                    "background_color": "#ffffff"
                  }
                },
                {
                  "id": 1,
                  "url": "/movies/1/",
                  "type": "Movie",
                  "cover": "http://minio:9000/flimix.flimix.co/uploads/other/12db8bb381bf408fb6ed9702b74177a3.webp",
                  "title": "Interstellar 2",
                  "genres": ["Scifi", "Adventure"],
                  "poster": "http://minio:9000/flimix.flimix.co/uploads/image/83931c83f164465fa67a5ea99adf14da.png",
                  "status": "Published",
                  "subtitle": "With Earth on the brink of collapse, a team of explorers travels through a wormhole in search of a new home for humanity."
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
              "background_color": "transparent"
            }
          },
          {
            "id": "block-ygms2og",
            "type": "carousel",
            "props": {
              "title": "Trending Now",
              "items": [
                {
                  "id": 10,
                  "title": "Game Changer",
                  "type": "Movie",
                  "poster": "http://localhost:9000/flimix.flimix.co/uploads/image/93978a0b58984f60a3d69b803ac02ee8.png"
                },
                {
                  "id": 4,
                  "title": "Aavesham 2",
                  "type": "Movie",
                  "poster": "http://minio:9000/flimix.flimix.co/uploads/image/38916a87ad754f0389460148044c3621.png"
                }
              ],
              "item_size": "small",
              "item_shape": "rectangle-landscape",
              "show_title": true,
              "show_arrows": true
            },
            "style": {
              "grid_gap": "sm",
              "padding_bottom": "10px"
            }
          },
          {
            "id": "block-9q4yiy0",
            "type": "carousel",
            "props": {
              "title": "Books Ratio",
              "items": [
                { "id": 32, "title": "Top Gun", "type": "Book" },
                { "id": 12, "title": "Avatar", "type": "Book" }
              ],
              "item_size": "small",
              "item_shape": "rectangle-portrait",
              "show_title": false
            },
            "style": {
              "grid_gap": "sm",
              "background_color": "rgba(255, 255, 255, 0)"
            }
          },
          {
            "id": "block-pgc0yco",
            "type": "carousel",
            "props": {
              "title": "Podcast and Albums",
              "items": [
                { "id": 15, "title": "Tech Talk Daily", "type": "Podcast" },
                { "id": 23, "title": "True Crime Files", "type": "Podcast" }
              ],
              "item_size": "small",
              "item_shape": "square",
              "show_subtitle": true
            },
            "style": {
              "grid_gap": "sm"
            }
          }
        ],
        "layout": {
          "canvas_bg": "#171717",
          "canvas_content_width": 85
        }
      }
    }
    """

    fun getHomePage(): PageResponse {
        return json.decodeFromString<PageResponse>(MOCK_RESPONSE)
    }
}
