import sbt._
import de.element34.sbteclipsify._

class SleepingBarberProject(info: ProjectInfo) extends DefaultProject(info)
                                   with IdeaProject with Eclipsify {

  /* Dependencies */
  // val commonsIO = "commons-io" % "commons-io" % "2.0.1" withSources()
  
  val scalaTest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1" withSources()
  
  val junit = "junit" % "junit" % "4.8.1" withSources()
}
