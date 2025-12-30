package model0
import domain.model.projects
import java.io.File
val linesOfproject = File("src/main/resources/project.csv").readLines().drop(1)
class projectsRepository : projectDataProvider {
    override fun fatchProject(file: File): List<projects> {
        return linesOfproject.map {
           val partsproject = it.split(",")
            projects(
                partsproject[0].trim(), partsproject[1].trim(),
                partsproject[2].trim())
        }
    }


}