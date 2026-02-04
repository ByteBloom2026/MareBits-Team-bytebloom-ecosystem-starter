package domain.usecase
import data.repository.MenteeRepository
import data.repository.ProjectRepository
class GetNumberOfProjectsByMenteeIdUseCase(
    private val menteeRepository: MenteeRepository,
    private val projectsRepository: ProjectRepository
) {
    operator fun invoke(menteeId: String): Int {
        val mentee = menteeRepository.getAllMentees()
            .find { it.id == menteeId }
            ?: return 0
        val teamId = mentee.teamId
        return projectsRepository.getAllProjects()
            .count { it.assignedTeamId == teamId }
    }
}