import parsePerformanceRaw

val teamslist  = parseTeamData()
val menteeslist = parseMenteeRaw()
val submissionslist = parsePerformanceRaw()

import model.PerformanceRaw
import model.TeamRaw
import model.MenteeRaw
import domain.Team
import domain.Mentee
import domain.PerformanceSubmission

class DomainBuilder (  teamslist: List<TeamRaw> ,
                       menteeslist: List<MenteeRaw>,
                       submissionslist: List<PerformanceRaw>)  {

    fun attachMenteeTeam (mentteId : String , teamId : String ): List<MenteeRaw> {
        val currentMentted = menteeslist.associateBy({ it.teamId })
        menteeslist.forEach {MenteeRaw ->
            val team =currentMentted[MenteeRaw.teamId]
        }
        return menteeslist
    }
    fun attachMenteePrefomance (mentteId : String , performance : String ): List<PerformanceRaw> {
        val currentperformance = submissionslist.associateBy({ it.menteeId})
        submissionslist.forEach {MenteeRaw ->
            val team =currentperformance[MenteeRaw.menteeId]
        }

        return submissionslist
    }
//    fun attachTeamPrefomance (teamId : String , performance : String ): List<TeamRaw> {
//        val currentTeam =teamslist.associateBy({it.teamId})
//        teamslist.forEach {MenteeRaw ->
//            val team =currentTeam[MenteeRaw.teamId]
//        }
//       // return teamslist
//    }


    }

























