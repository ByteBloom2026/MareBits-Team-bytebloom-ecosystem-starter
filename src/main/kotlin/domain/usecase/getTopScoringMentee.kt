package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository
import domain.model.Mentee

class getTopScoringMentee(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(): Mentee? =
        menteeRepository.getAllMentees().maxByOrNull { m ->
            val scores = performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score}
            scores.average().let { if (it.isNaN()) 0.0 else it }
        }
}