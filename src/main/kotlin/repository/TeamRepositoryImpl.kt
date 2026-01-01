package repository

import Repo.TeamRepository
import dataSource.CsvEcosystemDatasource
import domain.model.Team

class TeamRepositoryImpl(
    private val teamDataSource: CsvEcosystemDatasource
) : TeamRepository{
    override fun getTopTeam(): List<Team> {
        return teamDataSource.getTopTeam().map { row ->
            Team(
                teamId = row.teamId,
                teamName = row.teamName,
                mentorLead = row.mentorLead
            )

        }
    }
}