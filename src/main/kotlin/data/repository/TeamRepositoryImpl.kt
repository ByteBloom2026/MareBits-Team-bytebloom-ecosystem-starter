package data.repository
import domain.model.Team
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
class TeamRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : TeamRepository {
    override fun getAllTeams(): List<Team> =
        dataSource.getTeams().map { it.toDomain() }
    override fun getTeamById(teamId: String): Team? =
        dataSource.getTeamById(teamId)?.toDomain()
    override fun getMentorLeadByTeamId(teamId: String): String? =
        dataSource.getTeamById(teamId)?.mentorLead
}