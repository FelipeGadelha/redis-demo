package br.com.felipe.gadelha.redisdemo.domain.repository

import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.time.Duration

@Repository
class CacheRepository(
    private val zipCodeOps: ReactiveRedisOperations<String, String>
) {

    companion object {
        private val log = LoggerFactory.getLogger(CacheRepository::class.java)
    }

    fun save(key: String, value: String): Mono<Boolean> = zipCodeOps
        .opsForValue()
        .set(key, value)
        .then(zipCodeOps.expire(key, Duration.ofSeconds(60L)))
        .onErrorResume {
            Mono.just(false)
        }

    fun get(key: String): Mono<String> = zipCodeOps
        .opsForValue()
        .get(key)
        .doOnSuccess { log.info("sucesso no cache GET $it") }
        .doOnError { log.error("erro no cache GET $it") }
        .onErrorResume { Mono.empty() }


    fun exists(key: String): Mono<Boolean> = zipCodeOps
        .hasKey(key)
        .onErrorResume { Mono.just(false) }
}