package Repo

import domain.model.projects

interface projectsRepository {
    fun getAllproject(): List<projects>
}