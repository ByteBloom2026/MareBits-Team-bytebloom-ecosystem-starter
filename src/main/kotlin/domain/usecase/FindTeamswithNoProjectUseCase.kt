package domain.usecase

import data.repository.TeamRepository
import domain.model.Team

class FindTeamswithNoProjectUseCase(private val teamRepository: TeamRepository) {
    operator fun invoke(): List<Team> {
        return teamRepository.getAllTeams().filter { it.projects == null }
    }
}