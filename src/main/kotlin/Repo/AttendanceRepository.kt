package Repo

import domain.model.attendance


interface AttendanceRepository {
    fun getattendance(): List<attendance>
    //fun getAttendanceByMenteeId(menteeId: String):attendance?

}