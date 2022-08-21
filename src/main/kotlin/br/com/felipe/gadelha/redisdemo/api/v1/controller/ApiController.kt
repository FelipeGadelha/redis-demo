package br.com.felipe.gadelha.redisdemo.api.v1.controller

import br.com.felipe.gadelha.redisdemo.api.v1.dto.response.ZipCodeRs
import br.com.felipe.gadelha.redisdemo.domain.service.ZipCodeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/zip-code-info")
class ApiController(
    private val zipCodeService: ZipCodeService
) {
    companion object {
        private val log = LoggerFactory.getLogger(ApiController::class.java)
    }

    @GetMapping("/{zipCode}")
    fun findZipCodeInfo(@PathVariable zipCode: String): Mono<ZipCodeRs> =
        zipCodeService.findZipCode(zipCode)
            .map { ZipCodeRs(it) }
            .doOnError { log.error("Erro na requisição $it") }
            .doOnSuccess { log.info("Sucesso na requisição $it") }
}