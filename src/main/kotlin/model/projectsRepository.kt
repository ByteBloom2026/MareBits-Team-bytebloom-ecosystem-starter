package model
import model.projectsRaw
import java.io.File
val linesOfproject = File("src/main/resources/project.csv").readLines().drop(1)
class projectsRepository {
    fun parsprojectRaw(): List<projectsRaw> {
        return linesOfproject.map {
            val partsproject = it.split(",")
            projectsRaw(
                partsproject[0].trim(), partsproject[1].trim(),
                partsproject[2].trim()
            )
        }
    }
}