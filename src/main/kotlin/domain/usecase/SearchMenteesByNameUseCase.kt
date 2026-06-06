package domain.usecase
import data.repository.MenteeRepository
import domain.model.Mentee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchMenteesByNameUseCase (
    private val menteeRepository: MenteeRepository
) {
    suspend operator fun invoke(query: String): Result<Flow<Mentee>> {
        return menteeRepository.getAllMentees().map { mentees ->
            flow {
                mentees
                    .filter { mentee ->
                        mentee.name.contains(query, ignoreCase = true)
                    }
                    .forEach { mentee ->
                        emit(mentee)
                    }
            }
        }
    }
}