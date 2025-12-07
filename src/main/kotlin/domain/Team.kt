package domain

data class Team (
    val name: String,
    val mentees: MutableList<Mentee>
)
