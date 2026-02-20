package domain.validation.validators
import domain.validation.ValidationResult
import domain.validation.Validator

class SubmissionIdValidator : Validator<String> {
    private val idRegex = Regex("^sub\\d{3}$", RegexOption.IGNORE_CASE)
    override fun validate(data: String): ValidationResult<String> {
    val value = data.trim()
    if (value.isEmpty()) {
        return ValidationResult.failure("submissionId", "submission id is required.")
    }
    if (!idRegex.matches(value)) {
        return ValidationResult.failure("SubmissionId","It must begin with "sub" followed by 3 numbers.")
    }
    return ValidationResult.success(value.lowercase())
}

}

