package com.example.nortaltesttask.data.datasources

import com.example.nortaltesttask.data.models.Film
import com.example.nortaltesttask.data.models.MovieCategory
import com.example.nortaltesttask.R

class LocalCategories {

    fun createCategoriesList(): List<MovieCategory> {
        val comedies = listOf(
            Film(id = Math.random().toInt(), title = "Scrooged", poster = R.drawable.ic_scrooged),
            Film(
                id = Math.random().toInt(),
                title = "Groundhog Day",
                poster = R.drawable.ic_groundhog_day
            ),
            Film(id = Math.random().toInt(), title = "Friday", poster = R.drawable.ic_friday),
            Film(id = Math.random().toInt(), title = "Ted", poster = R.drawable.ic_ted),
            Film(
                id = Math.random().toInt(),
                title = "Zombieland",
                poster = R.drawable.ic_zombieland
            ),
            Film(
                id = Math.random().toInt(),
                title = "The Nutty Professor",
                poster = R.drawable.ic_the_nutty_professor
            ),
            Film(
                id = Math.random().toInt(),
                title = "The Truman Show",
                poster = R.drawable.ic_the_truman_show
            ),
            Film(
                id = Math.random().toInt(),
                title = "Fear and Loathing in Las Vegas",
                poster = R.drawable.ic_fear_and_loating_in_las_vegas
            ),
            Film(
                id = Math.random().toInt(),
                title = "The Waterboy",
                poster = R.drawable.ic_the_waterboy
            ),
            Film(
                id = Math.random().toInt(),
                title = "American Pie",
                poster = R.drawable.ic_scary_movie
            ),
            Film(
                id = Math.random().toInt(),
                title = "Scary Movie",
                poster = R.drawable.ic_american_pie
            )
        )
        val fantasy = listOf(
            Film(id = Math.random().toInt(), title = "Fantasy 1", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 2", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 3", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 4", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 5", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 6", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 7", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 8", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 9", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 10", poster = null),
            Film(id = Math.random().toInt(), title = "Fantasy 11", poster = null)
        )
        val science = listOf(
            Film(id = Math.random().toInt(), title = "Science 1", poster = null),
            Film(id = Math.random().toInt(), title = "Science 2", poster = null),
            Film(id = Math.random().toInt(), title = "Science 3", poster = null),
            Film(id = Math.random().toInt(), title = "Science 4", poster = null),
            Film(id = Math.random().toInt(), title = "Science 5", poster = null),
            Film(id = Math.random().toInt(), title = "Science 6", poster = null),
            Film(id = Math.random().toInt(), title = "Science 7", poster = null),
            Film(id = Math.random().toInt(), title = "Science 8", poster = null),
            Film(id = Math.random().toInt(), title = "Science 9", poster = null),
            Film(id = Math.random().toInt(), title = "Science 10", poster = null),
            Film(id = Math.random().toInt(), title = "Science 11", poster = null)
        )
        val action = listOf(
            Film(id = Math.random().toInt(), title = "Action 1", poster = null),
            Film(id = Math.random().toInt(), title = "Action 2", poster = null),
            Film(id = Math.random().toInt(), title = "Action 3", poster = null),
            Film(id = Math.random().toInt(), title = "Action 4", poster = null),
            Film(id = Math.random().toInt(), title = "Action 5", poster = null),
            Film(id = Math.random().toInt(), title = "Action 6", poster = null),
            Film(id = Math.random().toInt(), title = "Action 7", poster = null),
            Film(id = Math.random().toInt(), title = "Action 8", poster = null),
            Film(id = Math.random().toInt(), title = "Action 9", poster = null),
            Film(id = Math.random().toInt(), title = "Action 10", poster = null),
            Film(id = Math.random().toInt(), title = "Action 11", poster = null)
        )
        val drama = listOf(
            Film(id = Math.random().toInt(), title = "Drama 1", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 2", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 3", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 4", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 5", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 6", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 7", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 8", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 9", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 10", poster = null),
            Film(id = Math.random().toInt(), title = "Drama 11", poster = null)
        )

        return listOf(
            MovieCategory(
                id = Math.random().toInt(),
                category = R.drawable.ic_comedy,
                films = comedies
            ),
            MovieCategory(
                id = Math.random().toInt(),
                category = R.drawable.ic_fantasy,
                films = fantasy
            ),
            MovieCategory(
                id = Math.random().toInt(),
                category = R.drawable.ic_science,
                films = science
            ),
            MovieCategory(
                id = Math.random().toInt(),
                category = R.drawable.ic_action,
                films = action
            ),
            MovieCategory(id = Math.random().toInt(), category = R.drawable.ic_drama, films = drama)
        )
    }
}