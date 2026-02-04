package domain.usecase
import data.repository.AttendanceRepository
import data.repository.MenteeRepository
import domain.model.Mentee
import domain.model.AttendanceState
class GetPoorAttendanceMenteesUseCase (
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
)  {
    operator fun invoke(minAbsences: Int): List<Mentee> =
        menteeRepository.getAllMentees()
            .filter { mentee -> attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.count {it != AttendanceState.PRESENT }
                    ?.let { it >= minAbsences }
                    ?: false
            }
}