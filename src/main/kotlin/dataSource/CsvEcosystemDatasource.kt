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

class CsvEcosystemDatasource : EcoSystemDataSource {

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
    // fun parse
    private fun parseMenteeRow(): List<menteeRow> {
        return linesOfMentee.map {
            val parts = it.split(",")
            menteeRow(parts[0].trim(), parts[1].trim(), parts[2].trim())
        }
    }
    private fun parseTeamRow(): List<teamRow> {
        return linesOfTeam.map {
            val parts = it.split(",")
            teamRow(parts[0].trim(), parts[1].trim(),
                parts[2].trim())
        }
    }
    private fun parsePerformanceRow(): List<preformanceRow> {
        return linesOfPerformance.map {
            val parts = it.split(",")
            preformanceRow(parts[0].trim(), parts[1].trim(),
                parts[2].trim(), parts[3].trim())
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









