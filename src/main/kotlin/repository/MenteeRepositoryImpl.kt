package repository

import dataSource.CsvEcosystemDatasource
import domain.model.Mentee
import Repo.MenteeRepository

class MenteeRepositoryImpl(private val menteeDataSource: CsvEcosystemDatasource
): MenteeRepository {
    override fun getAllMentees():List<Mentee> {
        return menteeDataSource.parseMenteeRow().map { raw
            ->
            Mentee(
                id = raw.menteeId,
                name = raw.name,
                teamId = raw.teamId
            )

        }

    }
}