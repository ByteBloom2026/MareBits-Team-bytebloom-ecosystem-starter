package domain.model
import domain.validation.validators.*

data class Mentee  private constructor(
    val id: String,
    val name: String,
    val teamId: String
) {
    constructor(name: String, teamId: String) : this(
        id = java.util.UUID.randomUUID().toString(),
        name = name,
        teamId = teamId
    )

    companion object {
       val menteeNameValidator = MenteeNameValidator()
        val menteeIdValidator=MenteeIdValidator()

        fun create(id: String,name: String, teamId: String): Mentee {
            menteeNameValidator.validate(name)
            menteeIdValidator.validate(name)
            return Mentee(name, teamId)
        }
    }


}


