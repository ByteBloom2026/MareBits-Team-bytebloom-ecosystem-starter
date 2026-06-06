package presentation

class CommandParser {
    fun parse(input: String): Command {
        val parts = input.trim().split(" ")
        val command = parts.firstOrNull()?.lowercase()
        return when (command) {
            "search-teams" -> {
                val keyword = parts.drop(1).joinToString(" ")
                Command.SearchTeams(keyword)
            }
            "search-mentees" -> {
                val query = parts.drop(1).joinToString(" ")
                Command.SearchMentees(query)
            }
            "team-average" -> {
                Command.TeamAverageScore(parts.getOrElse(1) { "" })
            }
            "top-mentee" -> {
                Command.TopScoringMentee
            }
            "help" -> Command.Help
            "exit" -> Command.Exit
            else -> Command.Help
        }
    }
}