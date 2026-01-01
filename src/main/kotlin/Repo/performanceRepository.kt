package Repo

import domain.model.performanceSubmission

interface performanceRepository {
    fun getpreformance(): List<performanceSubmission>

}