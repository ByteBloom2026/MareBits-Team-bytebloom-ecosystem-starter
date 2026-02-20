package domain.validation.validators
import domain.validation.ValidationResult
import domain.validation.Validator

class MenteeIdValidator : Validator<String> {
    private val idRegex = Regex("^m\\d{3}$", RegexOption.IGNORE_CASE)
    override fun validate(data: String): ValidationResult<String> {
        val value = data.trim()
        if (value.isEmpty()) {
            return ValidationResult.failure("menteeId", "Mentee id is required.")
        }
        if (!idRegex.matches(value)) {
            return ValidationResult.failure("menteeId", "Mentee id must look like m001.")
        }
        return ValidationResult.success(value.lowercase())
    }
}