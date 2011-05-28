import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  // IDEA
  val sbtIdeaRepo = "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
  val sbtIdea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.4.0"
  
  // Eclipse
  val eclipse = "de.element34" % "sbt-eclipsify" % "0.7.0"
}