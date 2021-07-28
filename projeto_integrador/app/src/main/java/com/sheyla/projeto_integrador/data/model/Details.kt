package com.sheyla.projeto_integrador.data.model

data class Details(val id: Int,
                   val vote_average : Number,
                   val title : String,
                   val poster_path : String,
                   val category: List<Category>,
                   val overview: String
                   )

