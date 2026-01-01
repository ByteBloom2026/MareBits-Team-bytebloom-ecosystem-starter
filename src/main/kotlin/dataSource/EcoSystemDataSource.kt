package dataSource

import dataSource.model.menteeRow
import dataSource.model.teamRow
import dataSource.model.preformanceRow
import dataSource.model.projectRow
import dataSource.model.attendanceRow

interface EcoSystemDataSource {

    fun getMentees (): List<menteeRow>?
    fun getTeam () : List<teamRow>
    fun getpreformance () : List<preformanceRow>
    fun getproject () :List<projectRow>
    fun getattendance () : List<attendanceRow>
}