package model0
import domain.model.Mentee
import java.io.File
val linesOfMentee = File("src/main/resources/mentees.csv").readLines().drop(1)
class MenteeRepository : menteeDataProvider{
    override fun fatchMentees(file: File): List<Mentee> {
        return linesOfMentee.map {
            val partsMentee = it.split(",")
            Mentee(
                partsMentee[0].trim(), partsMentee[1].trim(),
                partsMentee[2].trim()
            )
      }
    }

}