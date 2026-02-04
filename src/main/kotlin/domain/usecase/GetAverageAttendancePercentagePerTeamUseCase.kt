package domain.usecase
import data.repository.AttendanceRepository
import data.repository.MenteeRepository
import data.repository.TeamRepository
import domain.model.AttendanceState
class GetAverageAttendancePercentagePerTeamUseCase (
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val attendanceRepository: AttendanceRepository
)
{
    operator fun invoke(): Map<String, Double> {
        return teamRepository.getAllTeams().associate { team ->
            val mentees = menteeRepository.getMenteesByTeamId(team.id)

            val percentages = mentees.mapNotNull { mentee ->
                attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.let { weeks ->
                        val presentCount = weeks.count { it == AttendanceState.PRESENT }
                        (presentCount.toDouble() / weeks.size) * 100
                    }
            }

            team.name to (percentages.average().takeIf { !it.isNaN() } ?: 0.0)
        }
    }
}