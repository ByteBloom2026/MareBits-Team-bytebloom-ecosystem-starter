import com.bytebloom.model.raw.TeamRaw
import java.io.File

fun parseTeamData(): List<TeamRaw>?{
    val teamList=mutableListOf<TeamRaw>()
    val readFile= File("src/main/resources/teams.csv").readLines()
    val CheckFile= readFile.drop(1).forEach {
            line -> if(line.isNotBlank()){
        val parts = line.split(",").map { it.trim() }
        val team=TeamRaw(parts[0],parts[1],parts[2])
        teamList.add(team)
    }
    }
    return if(teamList.isEmpty()){
        null
    }else{
       teamList
    }
}