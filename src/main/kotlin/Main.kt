import java.io.File



fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    val theNewMentees = parseMenteeRaw()
    if (theNewMentees != null) {
        println("totel mentees : {${theNewMentees.size}}")
    } else {
        println("no  find data on mentees file")
    }
    val theNewPerformance = parsePerformanceRaw()
    if (theNewPerformance != null) {
        println("totel preformance : {${theNewPerformance.size}}")
    } else {
        println("no  find data on predormance file")
    }
    val ParsedTeams = parseTeamData()
    if (ParsedTeams != null) {
        println("Total teams parsed : ${ParsedTeams.size}")
    } else {
        println("No team data available for parsing .")
    }


    

                                                                        


}
