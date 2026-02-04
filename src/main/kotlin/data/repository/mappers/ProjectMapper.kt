package data.repository.mappers
import data.datasource.model.ProjectRow
import domain.model.Project

fun ProjectRow.toDomain(): Project =
    Project(
        id =id,
        name=name,
        assignedTeamId = teamId
    )
