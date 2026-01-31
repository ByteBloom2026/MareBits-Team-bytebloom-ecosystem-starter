package domain.usecase

import Repository.MenteeRepository
import Repository.PerformanceRepository
import domain.model.Mentee

class getMenteesWithLowAverageScoreUseCase(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository
) {
    operator fun invoke(threshold: Double): List<Mentee> {
        return menteeRepository.getAllMentees()
            .filter { mentee ->
                val avgScore = performanceRepository.getPerformanceByMenteeId(mentee.id)
                    .map { it.score}
                    .average().let { if (it.isNaN()) 0.0 else it }


                avgScore < threshold
            }
    }

}