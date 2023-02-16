package br.com.spring.validate.sample.model.enum

enum class PersonErrors(val value: String) {
    INVALID_MIN_AGE("Age is lower than allowed"),
    INVALID_MAX_AGE("Age is greater than the allowed"),
    INVALID_CITY("Unsupported city"),
    INVALID_MIN_WEIGHT("Weight is lower than allowed"),
    INVALID_MAX_WEIGHT("Weight is greater than the allowed")
}