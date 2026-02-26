package domain.model
import domain.validation.validators.*

data class Mentee  private constructor(
    val id: String,
    val name: String,
    val teamId: String
){
    constructor(id: String,name: String,teamId: String) : this(
        id= java.util.UUID.randomUUID().toString(),
        name=name,
        teamId=teamId
    )

    companion object{
        val menteeIdValidator=MenteeIdValidator()
        val menteeNameValidator=MenteeNameValidator()
    }
    fun create(id: String,name: String,teamId: String):Mentee{
        menteeIdValidator.validate(id)
        menteeNameValidator.validate(name)
        return Mentee (id ,
            name,
            teamId)
    }
}