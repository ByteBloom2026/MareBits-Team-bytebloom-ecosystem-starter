package domain

data class Mentee (
    val name: String,
    val id:String,
    var team: Team? ,
    val submissions: MutableList<PerformanceSubmission>
)
