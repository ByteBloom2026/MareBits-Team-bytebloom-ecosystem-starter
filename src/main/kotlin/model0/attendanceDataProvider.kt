package model0
import domain.model.attendance
import java.io.File
interface attendanceDataProvider{
    fun fatchattendance (file : File) : List <attendance>
}