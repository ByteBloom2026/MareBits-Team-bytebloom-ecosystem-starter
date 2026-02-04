package domain.usecase
import data.repository.MenteeRepository
class GetMenteeNameByIdUseCase(
    private val menteeRepository: MenteeRepository
) {

     operator fun invoke(id: String): String? {
        val mentee = menteeRepository.getMenteeById(id)
        return mentee?.name

    }

}