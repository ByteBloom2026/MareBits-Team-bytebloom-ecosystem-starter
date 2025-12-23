package model
import model.TeamRaw
import java.io.File
val allFileLines = File("src/main/resources/teams.csv").readLines().drop(1)
class TeamRepository {
    fun parseTeamData(): List<TeamRaw>? {

        return allFileLines.map { currentRaw ->
            val teamFields = currentRaw.split(",").map { it.trim() }
            TeamRaw(teamFields[0], teamFields[1], teamFields[2], emptyList())
        }
    }
}