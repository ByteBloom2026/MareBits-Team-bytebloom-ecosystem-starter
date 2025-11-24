
fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter ☺")
    val parsedTeams = parseTeamData()
    if (parsedTeams!=null) {
        println("Total teams parsed : ${parsedTeams.size}")
    }else{
        println("No team data available for parsing .")
    }
}