package model0
import domain.model.Team
import java.io.File
interface teamDataProvider {
    fun fatchTeam(file : File): List<Team>
}
