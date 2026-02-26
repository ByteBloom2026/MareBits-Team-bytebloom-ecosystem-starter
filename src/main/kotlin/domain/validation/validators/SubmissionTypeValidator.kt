package domain.validation.validators
import domain.model.PerformanceSubmission
import domain.validation.ValidationResult
import domain.validation.Validator

class SubmissionTypeValidator: Validator<String> {
    private val allowedTypes =listOf("TASK","BOOK_CLUB","WORKSHOP")
    fun validate(data: PerformanceSubmission.SubmissionType): ValidationResult<String> {
        val value=data.trim().uppercase()
        if(value.isEmpty()){
            return ValidationResult.failure("submissionType", "Submission type is required.")
        }
        if (!allowedTypes.contains(value)){
            return ValidationResult.failure(
                "submissionType",
                "Invalid type. Allowed types are: ${allowedTypes.joinToString(", ")}"
            )
        }
        return ValidationResult.success(value)
    }
}

