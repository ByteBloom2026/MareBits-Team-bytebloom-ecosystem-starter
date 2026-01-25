package domain.usecase

import Repository.PerformanceRepository
import domain.averageOrZero

class getMenteePerformanceBreakdown(
    private val performanceRepository: PerformanceRepository
) {
    fun execute(menteeId: String): Map<String, Double> {
        val submissions = performanceRepository.getPerformanceByMenteeId(menteeId)
        return submissions.groupBy { it.submissionType }
            .mapValues { (_, list) ->
                list.map { it.score.toDoubleOrNull() ?: 0.0 }.averageOrZero()
            }
    }
}