package domain.usecase

import domain.model.SubmissionType
import data.repository.PerformanceRepository


class  GetMenteePerformanceBreakdownUseCase(
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(menteeId: String): Map<String, Double> {
        val submissions = performanceRepository.getPerformanceByMenteeId(menteeId)
        return submissions.groupBy { it.type }
            .mapValues { (_, list) ->
                val avg = list.map { it.score }.average()
                if (avg.isNaN()) 0.0 else avg
            }
    }
}