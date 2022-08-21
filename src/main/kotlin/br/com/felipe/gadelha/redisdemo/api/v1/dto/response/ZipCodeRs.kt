package br.com.felipe.gadelha.redisdemo.api.v1.dto.response

import br.com.felipe.gadelha.redisdemo.infra.client.v1.dto.response.ZipCodeClientRs

data class ZipCodeRs private constructor(
    val zipCode: String,
    val place: String,
    val complement: String?,
    val district: String,
    val city: String,
    val state: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
) {
    constructor(zipCodeClientRs: ZipCodeClientRs):
        this(
            zipCode = zipCodeClientRs.zipCode,
            place = zipCodeClientRs.place,
            complement = zipCodeClientRs.complement,
            district = zipCodeClientRs.district,
            city = zipCodeClientRs.city,
            state = zipCodeClientRs.state,
            ibge = zipCodeClientRs.ibge,
            gia = zipCodeClientRs.gia,
            ddd = zipCodeClientRs.ddd,
            siafi = zipCodeClientRs.siafi
        )
}
