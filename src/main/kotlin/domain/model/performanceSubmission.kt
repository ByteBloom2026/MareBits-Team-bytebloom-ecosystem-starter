package domain.model

data class performanceSubmission(
    val menteeId: String,
    val submissionId: String,
    val submissionType: String,
    val score: String
)