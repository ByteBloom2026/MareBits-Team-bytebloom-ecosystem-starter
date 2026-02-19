package domain.validation.validators
import domain.model.AttendanceState
import domain.validation.ValidationResult
import domain.validation.Validator
class DropoutRuleValidator : Validator<List<AttendanceState>> {
    override fun validate(data: List<AttendanceState>): ValidationResult<List<AttendanceState>> {
        if (data.isEmpty()) {
            return ValidationResult.failure("weeks", "Attendance weeks cannot be empty.")
        }
        val allAbsent = data.all { it == AttendanceState.ABSENT }
        if (allAbsent) {
            return ValidationResult.failure("attendance", "Mentee is inactive (absent in all weeks).")
        }
        return ValidationResult.success(data)
    }
}
