package domain.model
data class PerformanceSubmission(
    val id: String,
    val type: SubmissionType,
    val score: Double,
    val menteeId: String
)
enum class SubmissionType {
    TASK,WORKSHOP,BOOK_CLUB
}