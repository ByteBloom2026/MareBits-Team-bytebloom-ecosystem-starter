package domain
data class Team(
    val id :String,
    val name: String,
    val mentees: MutableList<Mentee>
)
