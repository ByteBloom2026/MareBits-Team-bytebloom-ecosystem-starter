package domain.usecase
import data.repository.TeamRepository
import domain.model.Team
class GroupTeamsByMentorUseCase(private val teamRepository: TeamRepository){
    operator fun invoke(): Map<String, List<Team>>{
        return teamRepository.getAllTeams().groupBy {it.mentorLead}
    }

}



