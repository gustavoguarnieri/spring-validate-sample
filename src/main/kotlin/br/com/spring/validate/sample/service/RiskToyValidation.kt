package br.com.spring.validate.sample.service

interface RiskToyValidation<O, K, V> {
    fun validate(obj: O, errors: MutableMap<K, V>)
}