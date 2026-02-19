package domain.validation.validators
import domain.model.AttendanceState
import domain.validation.ValidationResult
import domain.validation.Validator
class AttendanceWeeksValidator(
    private val expectedWeeks: Int = 3
) : Validator<List<AttendanceState>> {
    override fun validate(data: List<AttendanceState>): ValidationResult<List<AttendanceState>> {
        if (data.isEmpty()) {
            return ValidationResult.failure("weeks", "Attendance weeks cannot be empty.")
        }
        if (data.size != expectedWeeks) {
            return ValidationResult.failure("weeks", "Expected $expectedWeeks weeks of attendance.")
        }
        return ValidationResult.success(data)
    }
}
