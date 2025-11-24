import model.MenteeRaw
import model.PerformanceRaw
import java.io.File

val lines_of_mentee = File("src/main/resources/mentees.csv").readLines().drop(1)
fun parseMenteeRaw(): List<MenteeRaw> {
       return  lines_of_mentee.map {
          val parts_mentee = it.split(",")
           MenteeRaw(parts_mentee[0].trim(), parts_mentee[1].trim(), parts_mentee[2].trim())
       }
            }
val lines_of_performance = File("src/main/resources/performance.csv").readLines().drop(1)
fun parsePerformanceRaw(): List<PerformanceRaw> {
    return lines_of_performance.map {
      val parts_performance  = it.split(",")
        PerformanceRaw(parts_performance[0].trim(), parts_performance[1].trim(), parts_performance[2].trim(),parts_performance[3].trim())
   } }
