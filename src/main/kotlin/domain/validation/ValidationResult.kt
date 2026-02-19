package domain.validation

sealed class ValidationResult<out T> {
    data class Success<T>(val data: T) : ValidationResult<T>()
    data class Failure(val errors: List<ValidationError>) : ValidationResult<Nothing>()
    companion object {
        fun <T> success(data: T): ValidationResult<T> = Success(data)
        fun failure(field: String, message: String): ValidationResult<Nothing> =
            Failure(listOf(ValidationError(field, message)))
    }
}