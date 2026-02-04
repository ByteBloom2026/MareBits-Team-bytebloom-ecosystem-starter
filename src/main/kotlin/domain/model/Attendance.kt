package domain.model
data class Attendance(
    val menteeId: String,
    val weeks: List<AttendanceState>
    )
enum class AttendanceState {
    LATE,PRESENT,ABSENT
}