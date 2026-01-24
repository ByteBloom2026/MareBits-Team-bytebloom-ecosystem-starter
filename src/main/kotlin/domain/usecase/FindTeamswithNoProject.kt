package domain.usecase

import Repository.TeamRepository
import domain.model.Team


class FindTeamswithNoProject(private val teamRepository: TeamRepository){
    fun excute(): List<Team>{
        return teamRepository.getAllTeams().filter { it.project == null }
    }
}