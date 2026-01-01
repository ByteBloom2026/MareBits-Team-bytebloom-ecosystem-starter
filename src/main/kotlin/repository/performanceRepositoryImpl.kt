package repository

import Repo.performanceRepository
import dataSource.CsvEcosystemDatasource
import domain.model.performanceSubmission

class performanceRepositoryImpl(
    private val performanceDataSource:CsvEcosystemDatasource
): performanceRepository {
    override fun getpreformance(): List<performanceSubmission> {
        return performanceDataSource.getpreformance().map { row ->
            performanceSubmission(
                menteeId = row.menteeId,
                submissionId = row.submissionId,
                submissionType = row.submissionType,
                score=row.score
            )

        }
    }

}