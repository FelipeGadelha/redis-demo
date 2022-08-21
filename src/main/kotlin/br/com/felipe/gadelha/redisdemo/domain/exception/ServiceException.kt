package br.com.felipe.gadelha.redisdemo.domain.exception

data class ServiceException(
    override val message: String,
    val statusCode: Int
): RuntimeException(message)