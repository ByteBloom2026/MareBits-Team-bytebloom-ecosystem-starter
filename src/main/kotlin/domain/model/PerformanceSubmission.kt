package domain.model
import domain.validation.validators.*

data class PerformanceSubmission private constructor(
    val id: String,
    val type: SubmissionType,
    val score: Double,
    val menteeId: String
) {
    constructor(type: SubmissionType, score: Double, menteeId: String) : this(
        id = java.util.UUID.randomUUID().toString(),
        type = type,
        score = score,
        menteeId = menteeId
    )

    companion object {
        private val submissionIdValidator = SubmissionIdValidator()
        private val submissionTypeValidator = SubmissionTypeValidator()
        private val scoreValidator = ScoreValidator()
        private val menteeIdValidator = MenteeIdValidator()

        fun create(id: String, type: SubmissionType, score: Double, menteeId: String): PerformanceSubmission {
            submissionIdValidator.validate(id)
            submissionTypeValidator.validate(type)
            scoreValidator.validate(score)
            menteeIdValidator.validate(menteeId)
            return PerformanceSubmission(id,
                type,
                score,
                menteeId)
        }
    }

    enum class SubmissionType {
        TASK, WORKSHOP, BOOK_CLUB
    }
}







