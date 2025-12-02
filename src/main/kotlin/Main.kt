import java.io.File





fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    val the_new_mentees=parseMenteeRaw()
    if(the_new_mentees!=null){
        println("totel mentees : {${the_new_mentees.size}}")
    }else
    {
        println("no  find data on mentees file")
    }
    val the_new_performance= parsePerformanceRaw()
    if(the_new_performance!=null){
        println("totel preformance : {${the_new_performance.size}}")
    }else
    {
        println("no  find data on predormance file")
    }
    val parsedTeams = parseTeamData()
    if (parsedTeams!=null) {
        println("Total teams parsed : ${parsedTeams.size}")
    }else{
        println("No team data available for parsing .")
    }
}
