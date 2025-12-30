package model0
import domain.model.Team
import java.io.File
val allFileLines = File("src/main/resources/teams.csv").readLines().drop(1)
class TeamRepository : teamDataProvider {
     override fun fatchTeam(file: File): List<Team> {
         return allFileLines.map { currentRaw ->
            val teamFields = currentRaw.split(",").map { it.trim() }
             Team(teamFields[0], teamFields[1], teamFields[2], emptyList())
        }
     }












}