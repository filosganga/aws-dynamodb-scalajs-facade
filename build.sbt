val munitV = "1.0.0-M7"
val scalacheckEffectV = "2.0.0-M2"
val munitCatsEffectV = "2.0.0-M3"
val catsScalacheckV = "0.3.2"
val dynosaurV = "0.3.0-28-b99089c"

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / organization := "com.kaluza.kapi"
ThisBuild / organizationName := "Kaluza Ltd"
ThisBuild / dynverSeparator := "-"
ThisBuild / resolvers += "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/"
ThisBuild / evictionErrorLevel := Level.Warn
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

val commonsSettings = List(
  scalacOptions -= "-Xfatal-warnings",
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
      "org.systemfw" %%% "dynosaur-core" % dynosaurV,
      "org.scalameta" %%% "munit" % munitV % Test,
      "org.scalameta" %%% "munit-scalacheck" % munitV % Test,
      "org.typelevel" %%% "munit-cats-effect" % munitCatsEffectV % Test,
      "org.typelevel" %%% "cats-effect" % "3.4.6" % Test,
      "org.typelevel" %%% "scalacheck-effect-munit" % scalacheckEffectV % Test,
      "io.chrisdavenport" %%% "cats-scalacheck" % catsScalacheckV % Test
    )
  )
