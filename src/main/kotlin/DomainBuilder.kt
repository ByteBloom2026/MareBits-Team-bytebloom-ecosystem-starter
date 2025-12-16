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
        val basicMentees = rawMentees.map { mentee ->
            Mentee(mentee.id, mentee.name, mentee.teamId,emptyList())
        }
        val linkMenteesWithSubmission = basicMentees.map { mentee ->
            val submissionForMentee =
                rawSubmissions.filter { submission -> submission.menteeId == mentee.id }.map { rawPerformance ->
                    PerformanceSubmission(
                        rawPerformance.id,
                        rawPerformance.menteeId,
                        rawPerformance.submissionType,
                        rawPerformance.score
                    )
                }
            mentee.copy(submissions = submissionForMentee)
        }
        return linkMenteesWithSubmission
    }


}    private fun buildTeamsWithMentees(mentees: List<Mentee>): List<Team>? {
        return rawTeams?.map { teamRaw ->
            val teamMentees = mentees.filter { it.teamId == teamRaw.teamId }
            Team(teamRaw.teamId, teamRaw.teamName, teamRaw.mentorLead)


        }

}





























