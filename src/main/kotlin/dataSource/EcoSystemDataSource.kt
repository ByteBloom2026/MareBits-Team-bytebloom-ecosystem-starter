package dataSource

import dataSource.model.menteeRow
import dataSource.model.teamRow
import dataSource.model.preformanceRow
import dataSource.model.projectRow
import dataSource.model.attendanceRow

interface EcoSystemDataSource {

    fun getAllMentees (): List<menteeRow>
    fun getTopTeam () : List<teamRow>
    fun getpreformance () : List<preformanceRow>
    fun getAllproject () :List<projectRow>
    fun getattendance () : List<attendanceRow>
}