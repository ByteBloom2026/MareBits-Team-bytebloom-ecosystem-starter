package domain.usecase

import Repository.PerformanceRepository
import domain.averageOrZero

class getAverageScorePerSubmissionTypeUseCase(
    private val performanceRepository: PerformanceRepository
) {
    fun execute(): Map<String, Double> {
        val allPerformances = performanceRepository.getAllPerformance()

        return allPerformances
            .groupBy { it.submissionType }
            .mapValues { (_, submissions) ->
                submissions.map { it.score.toDoubleOrNull() ?: 0.0 }.averageOrZero()
            }
    }
}