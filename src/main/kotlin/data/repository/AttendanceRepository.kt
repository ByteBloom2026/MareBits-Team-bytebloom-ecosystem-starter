package data.repository
import domain.model.Attendance
interface AttendanceRepository {
    fun getAllAttendance(): List<Attendance>
    fun getAttendanceByMenteeId(menteeId: String): Attendance?

}