package domain.model
data class Team(
    val id: String,
    val name: String,
    val mentorLead: String,
    val projects: Project? = null
)