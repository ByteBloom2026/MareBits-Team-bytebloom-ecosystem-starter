package dataSource

import dataSource.model.attendanceRow
import dataSource.model.menteeRow
import dataSource.model.preformanceRow
import dataSource.model.projectRow
import dataSource.model.teamRow
import domain.model.Mentee
import domain.model.Team
import domain.model.attendance
import domain.model.projects
import model0.PerformanceSubmissionRaw
import model0.linesOfMentee
import model0.linesOfPerformance
import model0.linesOfproject
import java.io.File

val linesOfMentee = File("src/main/resources/mentees.csv").readLines().drop(1)
val lines0fTeam = File("src/main/resources/teams.csv").readLines().drop(1)
val linesOfPerformance = File("src/main/resources/performance.csv").readLines().drop(1)
val linesOfproject = File("src/main/resources/project.csv").readLines().drop(1)
val linesOfattendance = File("src/main/resources/attendance.csv").readLines().drop(1)

class CsvEcosystemDatasource : EcoSystemDataSource {

    override fun getAllMentees(): List<menteeRow> {
        parseMenteeRow()
        TODO("Not yet implemented")
    }
    override fun getTopTeam(): List<teamRow> {
        parseTeamRow()
        TODO("Not yet implemented")
    }
    override fun getpreformance(): List<preformanceRow> {
//        parsePreformance()
       TODO("Not yet implemented")
   }
    override fun getAllproject(): List<projectRow> {
        parseProject()
        TODO("Not yet implemented")
    }
    override fun getattendance(): List<attendanceRow> {
        parseattendance()
        TODO("Not yet implemented")
    }



    private fun parseMenteeRow (): List<Mentee> {
        return  linesOfMentee.map {
            val partsMentee = it.split(",")
            Mentee(
                partsMentee[0].trim(), partsMentee[1].trim(),
                partsMentee[2].trim()
            )
        }
    }
    private fun parseTeamRow ():List<Team>{
        return lines0fTeam.map {
            val partsTeam=it.split(",")
            Team(
                partsTeam[0].trim(),partsTeam[1].trim(),
                partsTeam[2].trim()
            )
        }
    }
//  private fun parsePreformance () :List<projectRow>{
//     return dataSource.linesOfPerformance.map {
//         val partsPreformance = it.split(",")
//         preformanceRow(
//             partsPreformance[0].trim(),partsPreformance[1].trim(),
//             partsPreformance[2].trim(),partsPreformance[3].trim()
//         )
//     }
//    }
    private fun parseProject() :List<projectRow>{
        return linesOfproject.map {
            val partsproject = it.split(",")
            projectRow(
                partsproject[0].trim(), partsproject[1].trim(),
                partsproject[2].trim()
            )
        }
    }
    private fun parseattendance (): List<attendanceRow>{
        return linesOfattendance.map {
            val parseattendance= it.split(",")
            attendanceRow(
                parseattendance[0].trim(),parseattendance[1].trim(),
                parseattendance[2].trim(),parseattendance[3].trim()
            )
        }
    }












    }








