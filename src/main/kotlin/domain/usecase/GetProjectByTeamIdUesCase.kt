package domain.usecase

import data.repository.TeamRepository
import domain.model.Project

class GetProjectByTeamIdUesCase(private val teamRepository: TeamRepository) {
    operator fun invoke(teamId: String): Project? {
        return teamRepository.getTeamById(teamId)?.projects

    }
}