package com.sheyla.projeto_integrador.data.mappers

import com.sheyla.projeto_integrador.data.model.cast.CastResponse
import com.sheyla.projeto_integrador.domain.Cast

class CastMapper {
    fun map(castList: List<CastResponse>): List<Cast>{
        val celebrities = mutableListOf<Cast>()
        castList.forEach {
            val celebrity = Cast(
                name = it.name,
                profile_path = it.profile_path,
                character = it.character
            )
            celebrities.add(celebrity)
        }
        return celebrities
    }


}