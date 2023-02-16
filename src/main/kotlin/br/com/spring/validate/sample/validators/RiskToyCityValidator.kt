package br.com.spring.validate.sample.validators

import br.com.spring.validate.sample.config.ValidationConfig
import br.com.spring.validate.sample.model.Person
import br.com.spring.validate.sample.model.enum.PersonErrors
import br.com.spring.validate.sample.model.enum.PersonErrors.INVALID_CITY
import br.com.spring.validate.sample.service.RiskToyValidation
import org.springframework.stereotype.Service

@Service
class RiskToyCityValidator(
    private val validationConfig: ValidationConfig
) : RiskToyValidation<Person, PersonErrors, String> {

    override fun validate(obj: Person, errors: MutableMap<PersonErrors, String>) {
        if (!isSupportedCity(obj)) {
            errors[INVALID_CITY] = INVALID_CITY.value
            println("validate: person city=${obj.city} is not supported")
        }
    }

    private fun isSupportedCity(person: Person) = validationConfig.supportedCities?.contains(person.city) == true
}