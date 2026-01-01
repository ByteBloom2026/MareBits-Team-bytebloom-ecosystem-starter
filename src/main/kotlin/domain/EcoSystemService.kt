package domain

import model0.MenteeRepository
import model0.TeamRepository
import model0.attendanceRepository
import model0.performanceRepository
import model0.projectsRepository

class EcoSystemService (
    private val teamRepo: TeamRepository,
    private val menteeRepo: MenteeRepository,
    private val performanceRepo: performanceRepository,
    private val projectRepo: projectsRepository,
    private val attendanceRepo: attendanceRepository
    )


