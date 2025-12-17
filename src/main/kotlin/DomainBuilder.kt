import domain.Mentee
import domain.PerformanceSubmission
import domain.Team

val rawTeams = parseTeamData()
val rawMentees = parseMenteeRaw()
val rawSubmissions = parsePerformanceRaw()

class DomainBuilder() {
    fun buildDomainGraph(): List<Team>? {
        val mentees = buildMenteesWithSubmissions()
        val teams = buildTeamsWithMentees(mentees)
        return teams
    }
    private fun buildMenteesWithSubmissions(): List<Mentee> {
        val basicMentees = createBasicMentees()
        return linkSubmissionsToMentees(basicMentees)
    }

    private fun createBasicMentees(): List<Mentee> =
        rawMentees.map { mentee ->
            Mentee(mentee.id, mentee.name, mentee.teamId, emptyList())
        }

    private fun linkSubmissionsToMentees(basicMentees: List<Mentee>): List<Mentee> {
        return basicMentees.map { mentee ->
            val submissions = getSubmissionsForMentee(mentee.id)
            mentee.copy(submissions = submissions)
        }
    }

    private fun getSubmissionsForMentee(menteeId: String): List<PerformanceSubmission> =
        rawSubmissions
            .filter { it.menteeId == menteeId }
            .map { rawPerformance ->
                PerformanceSubmission(
                    rawPerformance.id ,
                    rawPerformance.submissionType,
                    rawPerformance.score,
                    rawPerformance.menteeId
                )
            }

    private fun buildTeamsWithMentees(mentees: List<Mentee>): List<Team>? {
        return rawTeams?.map { teamRaw ->
            val teamMentees = mentees.filter { it.teamId == teamRaw.teamId }
            Team(teamRaw.teamId, teamRaw.teamName, teamMentees)
        }
}}





























