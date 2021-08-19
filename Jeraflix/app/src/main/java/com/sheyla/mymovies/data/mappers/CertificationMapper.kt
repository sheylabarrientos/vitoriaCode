package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.data.model.certification.ReleaseDatesResponse
import com.sheyla.mymovies.domain.Certification


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