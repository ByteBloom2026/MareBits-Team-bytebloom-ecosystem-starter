package domain

data class Mentee (
    val name: String,
    val menteeid:String,
    var team: Team? = null,
    val submissions: MutableList<PerformanceSubmission> = mutableListOf()
)
