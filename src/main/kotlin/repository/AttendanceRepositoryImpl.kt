package repository

import Repo.AttendanceRepository
import dataSource.CsvEcosystemDatasource
import domain.model.attendance

class AttendanceRepositoryImpl (
    private val attendanceDataSource: CsvEcosystemDatasource
): AttendanceRepository {
    override fun getattendance(): List<attendance> {
        return attendanceDataSource.getattendance().map { row
            ->
            attendance(
                menteeId = row.menteeId,
                week_1 = row.week_1,
                week_2 = row.week_2,
                week_3 = row.week_3)
        }
    }

}