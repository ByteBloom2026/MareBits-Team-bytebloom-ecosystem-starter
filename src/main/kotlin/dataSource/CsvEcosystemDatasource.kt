package dataSource

import dataSource.model.attendanceRow
import dataSource.model.menteeRow
import dataSource.model.preformanceRow
import dataSource.model.projectRow
import dataSource.model.teamRow
import java.io.File

val linesOfMentee = File("src/main/resources/mentees.csv").readLines().drop(1)
val linesOfTeam = File("src/main/resources/teams.csv").readLines().drop(1)
val linesOfPerformance = File("src/main/resources/performance.csv").readLines().drop(1)
val linesOfProject = File("src/main/resources/project.csv").readLines().drop(1)
val linesOfAttendance = File("src/main/resources/attendance.csv").readLines().drop(1)

open class CsvEcosystemDatasource : EcoSystemDataSource {

    override fun getMentees(): List<menteeRow>? {
        return parseMenteeRow()
    }

    override fun getTeam(): List<teamRow> {
        return parseTeamRow()
    }
    override fun getpreformance(): List<preformanceRow> {
        return parsePerformanceRow()
    }
    override fun getproject(): List<projectRow> {
        return parseProjectRow()
    }
    override fun getattendance(): List<attendanceRow> {
        return parseAttendanceRow()
    }



    private fun parseMenteeRow (): List<menteeRow> {
        return  linesOfMentee.map {
            val partsMentee = it.split(",")
            menteeRow(
                partsMentee[0].trim(), partsMentee[1].trim(),
                partsMentee[2].trim()
            )
        }
    }
    private fun parseTeamRow ():List<teamRow>{
        return lines0fTeam.map {
            val partsTeam=it.split(",")
            teamRow(
                partsTeam[0].trim(),partsTeam[1].trim(),
                partsTeam[2].trim()
            )
        }
    }
  private fun parsePreformance () :List<preformanceRow>{
     return dataSource.linesOfPerformance.map {
         val partsPreformance = it.split(",")
         preformanceRow(
             partsPreformance[0].trim(),partsPreformance[1].trim(),
             partsPreformance[2].trim(),partsPreformance[3].trim()
         )
     }
    }
    private fun parseProject() :List<projectRow>{
        return linesOfproject.map {
            val partsproject = it.split(",")
            projectRow(
                partsproject[0].trim(), partsproject[1].trim(),
                partsproject[2].trim()
            )
        }
    }
    private fun parseProjectRow(): List<projectRow> {
        return linesOfProject.map {
            val parts = it.split(",")
            projectRow(parts[0].trim(), parts[1].trim(),
                parts[2].trim())
        }
    }
    private fun parseAttendanceRow(): List<attendanceRow> {
        return linesOfAttendance.map {
            val parts = it.split(",")
            attendanceRow(parts[0].trim(), parts[1].trim(),
                parts[2].trim(), parts[3].trim())
        }
    }
    fun getMenteesByTeam(teamId: String): List<menteeRow> {
        val allMentees = parseMenteeRow()
        return allMentees.filter { it.teamId == teamId }
    }
    fun getProjectsByTeam(teamId :String ) : List<projectRow>{
        val allProject =parseProjectRow()
        return allProject.filter { it.teamId ==teamId }
    }
    fun getPerformanceByTeam(teamId : String ) : List<preformanceRow>{
        val allMentees = parseMenteeRow()
        val allPerformance = parsePerformanceRow()
        val menteeToTeam = allMentees.associate { it.menteeId to it.teamId }
        return allPerformance.filter { menteeToTeam[it.menteeId] == teamId }
    }
    fun getAttendanceByTeam( teamId: String) : List<attendanceRow>{
        val allattendance = parseAttendanceRow()
        val allmentees = parseMenteeRow()
        val menteeToTeam =allmentees.associate { it.menteeId to it.teamId }
        return allattendance.filter { menteeToTeam[it.menteeId]==teamId }
    }


}









