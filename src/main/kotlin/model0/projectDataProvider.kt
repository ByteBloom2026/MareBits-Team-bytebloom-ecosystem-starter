package model0
import domain.model.projects
import java.io.File
interface rojectDataProvider{
    fun fatchProject(file : File) : List<projects>
}