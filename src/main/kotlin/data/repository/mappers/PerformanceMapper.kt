package data.repository.mappers
import data.datasource.model.PerformanceRow
import domain.model.PerformanceSubmission


fun PerformanceRow.toDomain(): PerformanceSubmission =
    PerformanceSubmission(
        id = id,
        type = type,
        score = score,
        menteeId = menteeId
    )
