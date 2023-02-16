package br.com.spring.validate.sample.service

import br.com.spring.validate.sample.model.Person
import br.com.spring.validate.sample.model.enum.PersonErrors
import org.springframework.stereotype.Service

@Service
class RiskToyValidationProcessor(
    private val riskToyValidation: List<RiskToyValidation<Person, PersonErrors, String>>
) : RiskToyValidation<Person, PersonErrors, String> {
    override fun validate(obj: Person, errors: MutableMap<PersonErrors, String>) {
        riskToyValidation.forEach {
            it.validate(obj, errors)
        }
    }
}