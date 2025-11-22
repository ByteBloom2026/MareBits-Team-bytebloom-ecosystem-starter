
fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("✅ Project setup is correct and runnable.")
    val teams = parseTeamData()
    var total=0
    if (teams!=null) {
        for (team in teams){
            total +=1
        }
        println("Total teams parsed : $total")
    }else{
        println("No team data available for parsing .")
    }

}