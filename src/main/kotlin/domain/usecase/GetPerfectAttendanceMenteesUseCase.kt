package domain.usecase
import data.repository.AttendanceRepository
import data.repository.MenteeRepository
import domain.model.Mentee
import domain.model.AttendanceState
class GetPerfectAttendanceMenteesUseCase (
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
)
{
    operator fun invoke(): List<Mentee> =
        menteeRepository.getAllMentees()
            .filter { mentee -> attendanceRepository.getAttendanceByMenteeId(mentee.id)
                ?.weeks
                ?.all { it == AttendanceState.PRESENT }
                ?: false
            }
}