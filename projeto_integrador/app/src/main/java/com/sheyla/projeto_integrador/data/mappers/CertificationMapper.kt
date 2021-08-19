package com.sheyla.projeto_integrador.data.mappers

import com.sheyla.projeto_integrador.data.model.certification.ReleaseDatesResponse
import com.sheyla.projeto_integrador.domain.Certification

class CertificationMapper {
    fun map(certificationList: List<ReleaseDatesResponse>?): List<Certification>{
        val certifications = mutableListOf<Certification>()
        certificationList?.let {
            certificationList.forEach {
                val certification = Certification(
                    certification = it.certification,
                    type = it.type
                )
                certifications.add(certification)
            }
        }
        return certifications
    }
}