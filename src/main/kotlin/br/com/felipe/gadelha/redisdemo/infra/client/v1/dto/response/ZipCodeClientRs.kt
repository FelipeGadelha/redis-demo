package br.com.felipe.gadelha.redisdemo.infra.client.v1.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

class ZipCodeClientRs(
    @JsonProperty(value = "cep") val zipCode: String,
    @JsonProperty(value = "logradouro") val place: String,
    @JsonProperty(value = "complemento") val complement: String?,
    @JsonProperty(value = "bairro") val district: String,
    @JsonProperty(value = "localidade") val city: String,
    @JsonProperty(value = "uf") val state: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
)