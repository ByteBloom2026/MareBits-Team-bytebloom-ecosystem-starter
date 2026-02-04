package data.repository
import domain.model.Team
interface TeamRepository {
    fun getAllTeams(): List<Team>
    fun getTeamById(teamId: String): Team?
    fun getMentorLeadByTeamId(teamId: String): String?
}