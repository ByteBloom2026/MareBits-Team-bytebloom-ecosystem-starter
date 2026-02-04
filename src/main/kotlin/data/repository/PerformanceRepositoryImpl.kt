package data.repository
import domain.model.PerformanceSubmission
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
class PerformanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : PerformanceRepository {
    override fun getAllPerformance(): List<PerformanceSubmission> =
        dataSource.getPerformances().map { it.toDomain() }
    override fun getPerformanceByMenteeId(menteeId: String): List<PerformanceSubmission> =
        dataSource.getPerformanceByMenteeId(menteeId).map { it.toDomain() }
}
