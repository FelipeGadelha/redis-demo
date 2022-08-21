package br.com.felipe.gadelha.redisdemo.infra.client.v1

import br.com.felipe.gadelha.redisdemo.domain.exception.ServiceException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class ViaCepClient(
    val webClient: WebClient
) {

    companion object {
        private val log = LoggerFactory.getLogger(ViaCepClient::class.java)
    }

    fun findZipCodeInfo(zipCode: String): Mono<String> =
        webClient.get()
            .uri("/{zipCode}/json", zipCode)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) {
                error -> Mono.error(ServiceException(
                    "verifique os parâmetros informados",
                    error.rawStatusCode()))
            }.onStatus(HttpStatus::is5xxServerError) {
                error -> Mono.error(ServiceException(
                    "Internal server error",
                    error.rawStatusCode()))
            }.bodyToMono(String::class.java)
                .doOnSuccess { log.info("Sucesso no client ViaCep") }
}