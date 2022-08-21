package br.com.felipe.gadelha.redisdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean fun webClient(): WebClient = WebClient
        .builder()
        .baseUrl("https://viacep.com.br/ws")
        .build()
}