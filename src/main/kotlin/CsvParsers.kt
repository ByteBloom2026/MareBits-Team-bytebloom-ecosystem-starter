import model.MenteeRaw
import model.TeamRaw
import model.PerformanceSubmissionRaw
import java.io.File

val linesOfMentee = File("src/main/resources/mentees.csv").readLines().drop(1)
val allFileLines = File("src/main/resources/teams.csv").readLines().drop(1)
val linesOfPerformance = File("src/main/resources/performance.csv").readLines().drop(1)
fun parseMenteeRaw(): List<MenteeRaw> {
    return linesOfMentee.map {
        val partsMentee = it.split(",")
        MenteeRaw(
            partsMentee[0].trim(), partsMentee[1].trim(),
            partsMentee[2].trim()
        )
    }
}
fun parseTeamData(): List<TeamRaw>? {

    return allFileLines.map { currentRaw ->
        val teamFields = currentRaw.split(",").map { it.trim() }
        TeamRaw(teamFields[0], teamFields[1], teamFields[2], emptyList())
    }
}
fun parsePerformanceRaw(): List<PerformanceSubmissionRaw> {
    return linesOfPerformance.map {
        val partsPerformance = it.split(",")
        PerformanceSubmissionRaw(
            partsPerformance[0].trim(), partsPerformance[1].trim(),
            partsPerformance[2].trim(), partsPerformance[3].trim()
        )
    }
}
