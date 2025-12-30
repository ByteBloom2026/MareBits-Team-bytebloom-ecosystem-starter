package model0
import java.io.File
interface performanceDataProvider {
      fun  fatchperformance( file : File) :List <PerformanceSubmissionRaw>
}