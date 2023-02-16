package br.com.spring.validate.sample.validators

import br.com.spring.validate.sample.config.ValidationConfig
import br.com.spring.validate.sample.model.Person
import br.com.spring.validate.sample.model.enum.PersonErrors
import br.com.spring.validate.sample.model.enum.PersonErrors.INVALID_MIN_WEIGHT
import br.com.spring.validate.sample.model.enum.PersonErrors.INVALID_MAX_WEIGHT
import br.com.spring.validate.sample.service.RiskToyValidation
import org.springframework.stereotype.Service

@Service
class RiskToyWeightValidator(
    private val validationConfig: ValidationConfig
) : RiskToyValidation<Person, PersonErrors, String> {

    override fun validate(obj: Person, errors: MutableMap<PersonErrors, String>) {
        val minWeightInKg = validationConfig.minWeightInKg ?: 0
        val maxWeightInKg = validationConfig.maxWeightInKg ?: 0

        if (obj.weight < minWeightInKg) {
            errors[INVALID_MIN_WEIGHT] = INVALID_MIN_WEIGHT.value
            println("validate: person weight=${obj.age} is less than min age $minWeightInKg=allowed")
        }
        if (obj.weight > maxWeightInKg) {
            errors[INVALID_MAX_WEIGHT] = INVALID_MAX_WEIGHT.value
            println("validate: person weight=${obj.age} is greater than max age $maxWeightInKg=allowed")
        }
    }
}