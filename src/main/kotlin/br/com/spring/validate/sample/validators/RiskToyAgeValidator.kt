package br.com.spring.validate.sample.validators

import br.com.spring.validate.sample.config.ValidationConfig
import br.com.spring.validate.sample.model.Person
import br.com.spring.validate.sample.model.enum.PersonErrors
import br.com.spring.validate.sample.model.enum.PersonErrors.INVALID_MIN_AGE
import br.com.spring.validate.sample.model.enum.PersonErrors.INVALID_MAX_AGE
import br.com.spring.validate.sample.service.RiskToyValidation
import org.springframework.stereotype.Service

@Service
class RiskToyAgeValidator(
    private val validationConfig: ValidationConfig
) : RiskToyValidation<Person, PersonErrors, String> {

    override fun validate(obj: Person, errors: MutableMap<PersonErrors, String>) {
        val minAge = validationConfig.minAge ?: 0
        val maxAge = validationConfig.maxAge ?: 0

        if (obj.age < minAge) {
            errors[INVALID_MIN_AGE] = INVALID_MIN_AGE.value
            println("validate: person age=${obj.age} is less than min age=$minAge allowed")
        }
        if (obj.age > maxAge) {
            errors[INVALID_MAX_AGE] = INVALID_MAX_AGE.value
            println("validate: person age=${obj.age} is greater than max age=$maxAge allowed")
        }
    }
}