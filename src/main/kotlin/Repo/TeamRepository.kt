package Repo

import domain.model.Team

interface TeamRepository {
    fun getTopTeam(): List<Team>
}