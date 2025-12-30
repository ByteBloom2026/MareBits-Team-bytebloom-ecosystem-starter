package model0
import domain.model.attendance
import java.io.File
val linesOfattendance = File("src/main/resources/attendance.csv").readLines().drop(1)
class attendanceRepository : attendanceDataProvider {
    override fun fatchattendance(file: File): List<attendance> {
        return linesOfattendance.map {
            val partsattendance = it.split(",")
            attendance(
                partsattendance[0].trim(), partsattendance[1].trim(),
                partsattendance[2].trim(), partsattendance[2].trim()
            )
        }
    }
}