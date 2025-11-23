import java.io.File

fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    println("✅ Project setup is correct and runnable.")

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



}
