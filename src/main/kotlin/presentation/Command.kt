package presentation

sealed class Command {
    data class SearchTeams(val keyword: String) : Command()
    data class SearchMentees(val query: String) : Command()
    data class TeamAverageScore(val teamId: String) : Command()
    object TopScoringMentee : Command()
    object Help : Command()
    object Exit : Command()
}