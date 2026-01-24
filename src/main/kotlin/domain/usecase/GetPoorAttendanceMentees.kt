package domain.usecase
import Repository.AttendanceRepository
import Repository.MenteeRepository
import domain.model.Mentee
class GetPoorAttendanceMentees (
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
)  {
    fun execute(minAbsences: Int): List<Mentee> =
        menteeRepository.getAllMentees()
            .filter { mentee -> attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.count { it.uppercase() != "PRESENT" }
                    ?.let { it >= minAbsences }
                    ?: false
            }
}