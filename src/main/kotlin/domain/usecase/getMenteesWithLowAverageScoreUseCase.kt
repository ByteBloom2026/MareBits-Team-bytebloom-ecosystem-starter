package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository
import domain.averageOrZero
import domain.model.Mentee

class getMenteesWithLowAverageScoreUseCase(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    fun execute(threshold: Double): List<Mentee> {
        return menteeRepository.getAllMentees()
            .filter { mentee ->
                val avgScore = performanceRepository.getPerformanceByMenteeId(mentee.id)
                    .map { it.score.toDoubleOrNull() ?: 0.0 }
                    .averageOrZero()


                avgScore < threshold
            }
    }

}