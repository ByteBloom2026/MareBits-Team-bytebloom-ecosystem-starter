package domain.usecase

import Repository.PerformanceRepository

class getAverageScorePerSubmissionTypeUseCase(
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(): Map<String, Double> {
        val allPerformances = performanceRepository.getAllPerformance()

        return allPerformances
            .groupBy { it.submissionType }
            .mapValues { (_, submissions) ->
                submissions.map { it.score }.average().let { if (it.isNaN()) 0.0 else it }
            }
    }
}