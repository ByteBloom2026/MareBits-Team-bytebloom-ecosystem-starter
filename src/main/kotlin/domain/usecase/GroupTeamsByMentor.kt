package domain.usecase

import Repository.TeamRepository
import domain.model.Team

class GroupTeamsByMentor(private val teamRepository: TeamRepository){
    fun execute(): Map<String, List<Team>>{
        return teamRepository.getAllTeams().groupBy {it.mentorLead}
    }

}



