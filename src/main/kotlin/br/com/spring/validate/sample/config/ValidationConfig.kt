package br.com.spring.validate.sample.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "risk-toy-validation")
data class ValidationConfig(
    var minAge: Int? = 0,
    var maxAge: Int? = 0,
    var minWeightInKg: Int? = 0,
    var maxWeightInKg: Int? = 0,
    var supportedCities: List<String>? = emptyList()
)