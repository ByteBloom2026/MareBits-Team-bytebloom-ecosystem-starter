package domain.usecase
import Repository.AttendanceRepository
import Repository.MenteeRepository
import Repository.TeamRepository
class GetAverageAttendancePercentagePerTeam (
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val attendanceRepository: AttendanceRepository
)
{
    fun execute(): Map<String, Double> {
        return teamRepository.getAllTeams().associate { team ->
            val mentees = menteeRepository.getMenteesByTeamId(team.teamId)

            val percentages = mentees.mapNotNull { mentee ->
                attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.let { weeks ->
                        val presentCount = weeks.count { it.uppercase() == "PRESENT" }
                        (presentCount.toDouble() / weeks.size) * 100
                    }
            }

            team.teamName to (percentages.average().takeIf { !it.isNaN() } ?: 0.0)
        }
    }
}