package model0

import domain.model.performanceSubmission

data class Mentee(
    val id: String,
     val name: String,
      var teamId: String,
      val submissions: List<performanceSubmission>
)