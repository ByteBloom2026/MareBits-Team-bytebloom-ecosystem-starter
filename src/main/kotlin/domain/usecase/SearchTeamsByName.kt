package domain.usecase

import Repository.TeamRepository
import domain.model.Team

class SearchTeamsByName (private val teamRepository: TeamRepository){
    fun execute(query: String): List<Team> {
        return teamRepository.getAllTeams()
            .filter { it.teamName.contains(query, ignoreCase = true) }
    }
}


