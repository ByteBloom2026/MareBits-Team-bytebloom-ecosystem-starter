package Repo

import domain.model.Mentee

interface MenteeRepository {
    fun getAllMentees(): List<Mentee>
    //fun getMenteeById(id: String): Mentee?
    //fun getMenteesByTeamTd(teamId: String): List<Mentee>

}