package br.com.felipe.gadelha.redisdemo.domain.service

import br.com.felipe.gadelha.redisdemo.domain.repository.CacheRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CacheService(
    private val cacheRepository: CacheRepository
) {
    companion object {
        private val log = LoggerFactory.getLogger(CacheService::class.java)
    }

    fun get(key: String): Mono<String> = cacheRepository.get(key)

    fun save(key: String, value: String): Mono<String> = try {
        cacheRepository.save(key, value)
            .flatMap { saved ->
                if (saved) log.info("Cache salvo para a chave $key")
                else log.error("Não foi possível salvar cache para a chave $key")
                Mono.just(value)
            }
        } catch (ex: Exception) { Mono.just(value) }

    fun exists(key: String): Mono<Boolean> = cacheRepository.exists(key)
}