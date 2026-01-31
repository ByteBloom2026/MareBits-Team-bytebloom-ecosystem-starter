package domain.usecase

import Repository.PerformanceRepository


class  getMenteePerformanceBreakdown(
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(menteeId: String): Map<String, Double> {
        val submissions = performanceRepository.getPerformanceByMenteeId(menteeId)
        return submissions.groupBy { it.submissionType }
            .mapValues { (_, list) ->
                list.map { it.score }.average().let { if (it.isNaN()) 0.0 else it }
            }
    }
}