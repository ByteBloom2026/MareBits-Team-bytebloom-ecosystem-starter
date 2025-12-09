package model

data class PerformanceSubmissionRaw(
    val id: String,
    val submissionType: String,
    val score: String,
    val menteeId: String
)
