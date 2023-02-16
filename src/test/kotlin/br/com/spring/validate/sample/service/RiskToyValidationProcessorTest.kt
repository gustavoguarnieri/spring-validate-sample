package br.com.spring.validate.sample.service

import br.com.spring.validate.sample.BaseIntegrationTest
import br.com.spring.validate.sample.model.Person
import br.com.spring.validate.sample.model.enum.PersonErrors
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RiskToyValidationProcessorTest : BaseIntegrationTest() {

    @Autowired
    private lateinit var riskToyValidationProcessor: RiskToyValidationProcessor

    /**
     *  verify{} only on a mocked object. Anyway there is an implementation to do that, with the method: spyk()
     *  documentation: https://mockk.io/#spy
     */
    @Test
    fun shouldValidateAndNotContainsErrors() {
        val spiedRiskToyValidationProcessor = spyk(riskToyValidationProcessor)

        val person = Person(
            name = "Joao",
            age = 20,
            weight = 80,
            city = "Campinas"
        )

        val errors = mutableMapOf<PersonErrors, String>()

        spiedRiskToyValidationProcessor.validate(person, errors)

        verify(exactly = 1) {
            spiedRiskToyValidationProcessor.validate(any(), any())
        }
        assertEquals(errors.count(), 0)
    }

    @Test
    fun shouldValidateAndContainsErrors() {
        val spiedRiskToyValidationProcessor = spyk(riskToyValidationProcessor)

        val person = Person(
            name = "Joao",
            age = 15,
            weight = 45,
            city = "Fortaleza"
        )

        val errors = mutableMapOf<PersonErrors, String>()

        spiedRiskToyValidationProcessor.validate(person, errors)

        verify(exactly = 1) {
            spiedRiskToyValidationProcessor.validate(any(), any())
        }
        errors.containsKey(PersonErrors.INVALID_MIN_AGE)
        errors.containsKey(PersonErrors.INVALID_CITY)
        errors.containsKey(PersonErrors.INVALID_MIN_WEIGHT)
    }
}