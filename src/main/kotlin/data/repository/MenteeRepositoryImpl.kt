package data.repository
import domain.model.Mentee
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
class MenteeRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : MenteeRepository {
    override fun getAllMentees(): List<Mentee> =
        dataSource.getMentees().map { it.toDomain() }
    override fun getMenteeById(id: String): Mentee? =
        dataSource.getMenteeById(id)?.toDomain()
    override fun getMenteesByTeamId(teamId: String): List<Mentee> =
        dataSource.getMenteesByTeamId(teamId).map { it.toDomain() }
}