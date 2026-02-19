package domain.validation

interface Validator<T> {
    fun validate(data: T): ValidationResult<T>
}