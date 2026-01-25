package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository
import domain.averageOrZero
import domain.model.Mentee

class getTopScoringMentee(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    fun execute(): Mentee? =
        menteeRepository.getAllMentees().maxByOrNull { m ->
            val scores = performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score.toDoubleOrNull() ?: 0.0 }
            scores.averageOrZero()
        }
}