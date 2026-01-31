package domain.usecase

import domain.model.SubmissionType
import data.repository.PerformanceRepository

class GetAverageScorePerSubmissionTypeUseCase(
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(): Map<String, Double> {
        val allPerformances = performanceRepository.getAllPerformance()

        return allPerformances
            .groupBy { it.type }
            .mapValues { (_, submissions) ->
                submissions.map { it.score }.average().let { if (it.isNaN()) 0.0 else it }
            }
    }
}