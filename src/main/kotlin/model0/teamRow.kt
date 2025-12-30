package model0

import model0.Mentee

data class teamRow(
    val id :String,
    val name: String,
    val mentees: MutableList<Mentee>
)