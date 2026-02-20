package domain.validation.validators
import data.Validator.validator
import domain.validation.ValidationResult
import domain.validation.Validator

class MenteeNameValidator: validator<String> {
    fun validate(data: String): ValidationResult<String>{
        val value = data.trim()
        if(value.isEmpty())
            return ValidationResult.failure("The mentee name","cannot be empty.")
        if(value[1].isUpperCase())
            return ValidationResult.failure("","The first letter of the name mentee must be capitalized.")
        return ValidationResult.success(value)

    }
}