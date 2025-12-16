package domain
data class PerformanceSubmission(
    val id: String,
    val submissionType: String,
    val score: String,
    val menteeId: String
)
