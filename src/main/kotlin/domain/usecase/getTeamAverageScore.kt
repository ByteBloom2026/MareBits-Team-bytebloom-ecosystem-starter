package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository
import domain.averageOrZero

class getTeamAverageScore(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    fun execute(teamId: String): Double {
        val mentees = menteeRepository.getMenteesByTeamId(teamId)
        val allScores = mentees.flatMap { m ->
            performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score.toDoubleOrNull() ?: 0.0 }
        }
        return allScores.averageOrZero()
    }
}