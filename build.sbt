val munitV = "1.0.0-M7"
val scalacheckEffectV = "2.0.0-M2"
val munitCatsEffectV = "2.0.0-M3"
val catsScalacheckV = "0.3.2"

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "3.2.2"
ThisBuild / crossScalaVersions := List("2.13.10")
ThisBuild / organization := "com.filippodeluca"
ThisBuild / organizationName := "Filippo De Luca"
ThisBuild / dynverSeparator := "-"
ThisBuild / resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"
ThisBuild / evictionErrorLevel := Level.Warn
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / dynverSonatypeSnapshots := true

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
ThisBuild / credentials ++= {
  for {
    usr <- sys.env.get("SONATYPE_USER")
    password <- sys.env.get("SONATYPE_PASS")
  } yield Credentials("Sonatype Nexus Repository Manager", "s01.oss.sonatype.org", usr, password)
}.toList

val commonsSettings = List(
  scalacOptions -= "-Xfatal-warnings",
  scalacOptions -= "-Wdead-code",
  scalacOptions += "-Xsource:3"
)

lazy val dynamodbJsFacade = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .settings(
    name := "dynamodb-js-facade",
    commonsSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies += "@aws-sdk/client-dynamodb" -> "3.267.0",
    libraryDependencies ++= List(
      "org.scalameta" %%% "munit" % munitV % Test,
      "org.scalameta" %%% "munit-scalacheck" % munitV % Test,
      "org.typelevel" %%% "munit-cats-effect" % munitCatsEffectV % Test,
      "org.typelevel" %%% "cats-effect" % "3.4.6" % Test,
      "org.typelevel" %%% "scalacheck-effect-munit" % scalacheckEffectV % Test,
      "io.chrisdavenport" %%% "cats-scalacheck" % catsScalacheckV % Test
    )
  )
