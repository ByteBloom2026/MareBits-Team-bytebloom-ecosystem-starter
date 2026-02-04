package domain.usecase
import domain.model.Mentee
import data.repository.MenteeRepository
import data.repository.TeamRepository
class IsMenteeInTeamUseCase(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
) {
    operator fun invoke(menteeId:String,teamName:String): Boolean{
        val mentee = menteeRepository.getAllMentees()
            .find { it.id == menteeId }
            ?: return false
        return ismenteeInTheTeam(mentee, teamName)
    }

    private fun ismenteeInTheTeam(mentee: Mentee, teamName: String): Boolean {
        return teamRepository.getAllTeams()
            .find { it.id == mentee.teamId }
            ?.name == teamName
    }
}