package br.com.felipe.gadelha.redisdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.data.redis.core.ReactiveStringRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.RedisSerializationContext.RedisSerializationContextBuilder
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {

//    @Bean @Primary
//    fun redisOperations(factory: ReactiveRedisConnectionFactory?): ReactiveRedisOperations<String, String>? {
//        val serializer: Jackson2JsonRedisSerializer<String> = Jackson2JsonRedisSerializer(String::class.java)
//
//        val builder: RedisSerializationContextBuilder<String, String> =
//                RedisSerializationContext.newSerializationContext(StringRedisSerializer())
//
//        val context: RedisSerializationContext<String, String> = builder.value(serializer).build()
//        return ReactiveStringRedisTemplate(factory!!, context)
//    }

//    @Bean
//    fun redisOperations(factory: ReactiveRedisConnectionFactory?): ReactiveRedisOperations<String, ZipCodeClientRs>? {
//        val serializer: Jackson2JsonRedisSerializer<ZipCodeClientRs> = Jackson2JsonRedisSerializer(ZipCodeClientRs::class.java)
//        val builder: RedisSerializationContextBuilder<String, ZipCodeClientRs> = RedisSerializationContext.newSerializationContext<String, ZipCodeClientRs>(StringRedisSerializer())
//        val context: RedisSerializationContext<String, ZipCodeClientRs> = builder.value(serializer).build()
//        return ReactiveRedisTemplate(factory!!, context)
//    }

//    @Bean
//    fun redisConnectionFactory(): LettuceConnectionFactory {
//        return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
//    }

//    @Bean
//    fun redisTemplate(): RedisTemplate<String, ZipCodeClientRs> {
//        return RedisTemplate<String, ZipCodeClientRs>().apply {
//        setConnectionFactory(redisConnectionFactory())
//    }
}