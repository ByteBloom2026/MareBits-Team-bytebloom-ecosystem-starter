package repository

import Repo.projectsRepository
import dataSource.CsvEcosystemDatasource
import domain.model.projects

class projectsRepositoryImpl
    (private val projectDataSource: CsvEcosystemDatasource)
    : projectsRepository {
    override fun getAllproject(): List<projects> {
        return projectDataSource.getAllproject().map {row ->
            projects(
            projectId=row.projectId,
            projectName=row.projectName,
            teamId=row.teamId)

        }
    }
}