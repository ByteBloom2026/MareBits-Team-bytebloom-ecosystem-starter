package domain.model
import domain.validation.validators.*
import java.util.UUID

data class Team  private constructor(
    val id: String,
    val name: String,
    val mentorLead: String,
    val projects: Project? = null
){
    constructor(id: String,name: String,mentorLead: String,project: Project) : this(
        id= id,
        name=name,
        mentorLead=mentorLead,
        projects=project
    )

    companion object {
        val teamNameValidator=TeamNameValidator()
        val menteeNameValidator=MenteeNameValidator()
    }

    fun create(id: String,name: String,mentorLead: String,project: Project): Team {
        teamNameValidator.validate(name)
        menteeNameValidator.validate(mentorLead)
        return Team(
            id ,
            name ,
            mentorLead ,
            project
        )
    }
}