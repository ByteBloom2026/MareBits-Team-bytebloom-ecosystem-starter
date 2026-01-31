package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository


class getTeamAverageScore(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(teamId: String): Double {
        val mentees = menteeRepository.getMenteesByTeamId(teamId)
        val allScores = mentees.flatMap { m ->
            performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score}
        }
        return allScores.average().let { if (it.isNaN()) 0.0 else it }
    }
}