package domain.usecase

import Repository.TeamRepository

class CountTeamsByMentor (private val teamRepository: TeamRepository){
    fun execute(): Map<String, Int>{
        return teamRepository.getAllTeams()
            .groupBy{it.mentorLead}
            .mapValues { (_, teams) -> teams.size }
    }
}









