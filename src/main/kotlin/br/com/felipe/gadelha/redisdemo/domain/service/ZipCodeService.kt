package br.com.felipe.gadelha.redisdemo.domain.service

import br.com.felipe.gadelha.redisdemo.infra.client.v1.ViaCepClient
import br.com.felipe.gadelha.redisdemo.infra.client.v1.dto.response.ZipCodeClientRs
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ZipCodeService(
    private val viaCepClient: ViaCepClient,
    private val cacheService: CacheService,
    private val objectMapper: ObjectMapper
) {
    companion object {
        private val log = LoggerFactory.getLogger(ZipCodeService::class.java)
    }

    fun findZipCode(zipCode: String): Mono<ZipCodeClientRs> =
        cacheService.exists(zipCode)
            .flatMap { exists ->
                return@flatMap if (exists) cacheService.get(zipCode)
                    else viaCepClient.findZipCodeInfo(zipCode)
                    .flatMap { response -> cacheService.save(zipCode, response) }
            }.flatMap { handleResponse(it) }

    private fun handleResponse(response: String): Mono<ZipCodeClientRs> = try {
            Mono.just(objectMapper.readValue(response, ZipCodeClientRs::class.java))
        } catch (ex: Exception) {
            log.error("Erro ao tentar converter resposta do CEP.", ex)
            Mono.empty()
        }
}
