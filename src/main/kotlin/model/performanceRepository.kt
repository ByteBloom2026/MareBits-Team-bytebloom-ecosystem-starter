package model
import model.PerformanceSubmissionRaw
import java.io.File
val linesOfPerformance = File("src/main/resources/performance.csv").readLines().drop(1)
class performanceRepository {
    fun parsePerformanceRaw(): List<PerformanceSubmissionRaw> {
        return linesOfPerformance.map {
            val partsPerformance = it.split(",")
            PerformanceSubmissionRaw(
                partsPerformance[0].trim(), partsPerformance[1].trim(),
                partsPerformance[2].trim(), partsPerformance[3].trim()
            )
        }
    }
}