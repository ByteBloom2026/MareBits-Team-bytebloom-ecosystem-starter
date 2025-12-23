package model
import domain.Mentee
data class TeamRaw(
    val id: String,
    val name: String,
    val mentorLead: String,
    val mentees: List<Mentee>
)


