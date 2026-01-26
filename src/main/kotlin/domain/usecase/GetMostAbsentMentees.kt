package domain.usecase
import Repository.AttendanceRepository
import Repository.MenteeRepository
import domain.model.Mentee
class GetMostAbsentMentees (
    private val menteeRepository: MenteeRepository,
    private val attendanceRepository: AttendanceRepository
){
    fun execute(): List<Pair<Mentee, Int>> {
        return menteeRepository.getAllMentees()
            .mapNotNull { mentee ->
                attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.let { weeks ->
                        val absentCount = weeks.count { it.uppercase() != "PRESENT" }
                        mentee to absentCount
                    }
            }
            .sortedByDescending { it.second }
    }
}