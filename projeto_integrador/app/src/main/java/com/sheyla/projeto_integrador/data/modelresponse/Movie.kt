package com.sheyla.projeto_integrador.data.modelresponse

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdrop_path: String = "",
    @SerializedName("genre_ids")
    val genre_ids: List<Int> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("original_language")
    val original_language: String = "",
    @SerializedName("original_title")
    val original_title: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val poster_path: String = "",
    @SerializedName("release_date")
    val release_date: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val vote_average: Double = 0.0,
    @SerializedName("vote_count")
    val vote_count: Int = 0
)

data class ReleaseDatesResponse (
    @SerializedName ("id")
    val id : Int,
    @SerializedName ("results")
    val results: List<GuidanceResponse>) {

    data class GuidanceResponse(
        @SerializedName("iso")
        val iso_3166_1: String,
        @SerializedName("release_dates")
        val release_dates: List<ReleaseDate>
    )

    data class ReleaseDate(
        @SerializedName("certification")
        val certification: String,
        @SerializedName("type")
        val type: Int
    )

    data class ReleaseInfo(val certification: ReleaseInfo)

    override fun toString(): String {
        var certIso = ""
        for (i in results) {
            if (i.iso_3166_1 == "BR") {
                certIso += i.release_dates[0].certification
            }
        }
        return certIso
    }
}

data class Runtime (
                    @SerializedName ("id")
                    val id: Int,
                    @SerializedName ("runtime")
                    val runtime : Int?)

//A classe a seguir sé para implementação dos detalhes do "cast".

data class InfosCast(
                     @SerializedName ("profile_path")
                     val profile_path : String?,
                     @SerializedName ("name")
                     val name : String,
                     @SerializedName ("character")
                     val character : String)

//A classe a seguir é para implementação dos gêneros de filmes.

data class AllMoviesGenres (
                            @SerializedName ("id")
                            val id : Int,
                            @SerializedName ("name")
                            val name : String)