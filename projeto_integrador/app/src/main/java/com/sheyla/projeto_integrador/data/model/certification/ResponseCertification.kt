package com.sheyla.projeto_integrador.data.model.certification

import com.google.gson.annotations.SerializedName

class ResponseCertification(@SerializedName("results") val results: List<CertificationResponse>)
