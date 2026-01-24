package domain.usecase


import Repository.TeamRepository
import domain.model.Project

class GetProjectByTeamId (private val teamRepository: TeamRepository) {
    fun excute(teamId: String): Project?{
        return teamRepository.getTeamById(teamId)?.project

    }
}