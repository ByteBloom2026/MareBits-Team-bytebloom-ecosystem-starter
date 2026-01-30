package repository.mappers
import data.dataSource.model.AttendanceRow
import domain.model.Attendance
fun AttendanceRow.toDomain(): Attendance =
    Attendance(
        menteeId,weeks

    )
