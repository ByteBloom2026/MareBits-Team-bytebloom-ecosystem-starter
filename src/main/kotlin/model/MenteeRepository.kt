package model
import model.MenteeRaw
import java.io.File
val linesOfMentee = File("src/main/resources/mentees.csv").readLines().drop(1)
class MenteeRepository {
    fun parseMenteeRaw(): List<MenteeRaw> {
        return linesOfMentee.map {
            val partsMentee = it.split(",")
            MenteeRaw(
                partsMentee[0].trim(), partsMentee[1].trim(),
                partsMentee[2].trim()
            )
        }
    }
}