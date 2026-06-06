import di.appModule
import domain.usecase.GetTeamAverageScoreUseCase
import domain.usecase.GetTopScoringMenteeUseCase
import domain.usecase.SearchMenteesByNameUseCase
import domain.usecase.SearchTeamsByNameUseCase
import domain.usecase.request.GetTeamAverageScoreRequest
import domain.usecase.request.SearchTeamsByNameRequest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin
import presentation.Command
import presentation.CommandParser
import kotlinx.coroutines.Dispatchers

fun main ()=runBlocking {
    startKoin {
        modules(appModule)
    }
    val koin = getKoin()
    val commandParser = CommandParser()
    val searchTeamsByNameUseCase: SearchTeamsByNameUseCase = koin.get()
    val searchMenteesByNameUseCase: SearchMenteesByNameUseCase = koin.get()
    val getTeamAverageScoreUseCase: GetTeamAverageScoreUseCase = koin.get()
    val getTopScoringMenteeUseCase: GetTopScoringMenteeUseCase = koin.get()
    println("Welcome to Ecosystem CLI")
    printHelp()
    while (true) {
        print("\n> ")
        val input = readLine() ?: continue
        if (input.isBlank()) continue
        when (val command = commandParser.parse(input)) {
            is Command.SearchTeams -> launch(Dispatchers.Default) {
                println("Search teams command started")
                println("Keyword = ${command.keyword}")

                try {
                    val result = searchTeamsByNameUseCase(
                        SearchTeamsByNameRequest(command.keyword)
                    )

                    result
                        .onSuccess { teams ->
                            println("Found ${teams.size} teams")

                            if (teams.isEmpty()) {
                                println("No teams found.")
                            } else {
                                teams.forEach { team ->
                                    println("${team.id} - ${team.name} - Mentor: ${team.mentorLead}")
                                }
                            }
                        }
                        .onFailure {
                            println("Error inside result: ${it.message}")
                            it.printStackTrace()
                        }

                } catch (e: Exception) {
                    println("Exception caught in command:")
                    e.printStackTrace()
                }
            }.join()
            is Command.SearchMentees -> launch(Dispatchers.Default) {
                println("Search mentees command started")
                println("Query = ${command.query}")

                try {
                    searchMenteesByNameUseCase(command.query)
                        .onSuccess { menteesFlow ->
                            menteesFlow
                                .debounce(500)
                                .collect { mentee ->
                                    println("${mentee.id} - ${mentee.name} - Team: ${mentee.teamId}")
                                }
                        }
                        .onFailure {
                            println("Error inside result: ${it.message}")
                            it.printStackTrace()
                        }
                } catch (e: Exception) {
                    println("Exception caught in search mentees:")
                    e.printStackTrace()
                }
            }.join()
            is Command.TeamAverageScore -> launch (Dispatchers.Default){
                getTeamAverageScoreUseCase(GetTeamAverageScoreRequest(command.teamId))
                    .onSuccess { average ->
                        println("Team average score: $average")
                    }
                    .onFailure {
                        println("Error: ${it.message}")
                    }
            }.join()
            Command.TopScoringMentee -> launch (Dispatchers.Default){
                getTopScoringMenteeUseCase()
                    .onSuccess { mentee ->
                        if (mentee == null) {
                            println("No mentee found.")
                        } else {
                            println("Top mentee: ${mentee.name}")
                        }
                    }
                    .onFailure {
                        println("Error: ${it.message}")
                    }
            }.join()
            Command.Help -> {
                printHelp()
            }
            Command.Exit -> {
                println("Goodbye!")
                break
            }
        }
    }
}
fun printHelp() {
    println(
        """
        Available commands:
        search-teams <keyword>
        search-mentees <query>
        team-average <teamId>
        top-mentee
        help
        exit
        """.trimIndent()
    )
}
