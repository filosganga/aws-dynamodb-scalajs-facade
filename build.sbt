val munitV = "1.0.0-M8"
val scalacheckEffectV = "2.0.0-M2"
val munitCatsEffectV = "2.0.0-M3"
val catsScalacheckV = "0.3.2"
val catsEffectV = "3.5.1"

val awsSdkJsV = "3.267.0"

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "3.2.2"
ThisBuild / crossScalaVersions ++= List("2.13.10")
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
  } yield Credentials(
    "Sonatype Nexus Repository Manager",
    "s01.oss.sonatype.org",
    usr,
    password
  )
}.toList

ThisBuild / developers := List(
  Developer(
    id = "filosganga",
    name = "Filippo De Luca",
    email = "me@filippodeluca.com",
    url = url("https://github.com/filosganga")
  )
)

ThisBuild / licenses := List(
  License.Apache2
)

ThisBuild / homepage := Some(
  url("https://github.com/filosganga/dynamodb-js-facade")
)

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/filosganga/dynamodb-js-facade"),
    "scm:git@github.com:filosganga/dynamodb-js-facade.git"
  )
)

val commonsSettings = List(
  scalacOptions -= "-Xfatal-warnings",
  scalacOptions -= "-Wdead-code",
  scalacOptions += "-Xsource:3"
)

val testSettings = List(
  libraryDependencies ++= List(
    "org.scalameta" %%% "munit" % munitV % Test,
    "org.scalameta" %%% "munit-scalacheck" % munitV % Test,
    "org.typelevel" %%% "munit-cats-effect" % munitCatsEffectV % Test,
    "org.typelevel" %%% "cats-effect" % catsEffectV % Test,
    "org.typelevel" %%% "scalacheck-effect-munit" % scalacheckEffectV % Test,
    "io.chrisdavenport" %%% "cats-scalacheck" % catsScalacheckV % Test
  )
)

lazy val root = project
  .in(file("."))
  .aggregate(core, clientDynamodb, clientS3, clientSes, clientKinesis)

lazy val core = project
  .in(file("modules/core"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .settings(
    name := "scalajs-awssdk-types",
    commonsSettings,
    testSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies ++= List(
      "@aws-sdk/types" -> awsSdkJsV,
      "@aws-sdk/middleware-signing" -> awsSdkJsV,
      "@aws-sdk/middleware-retry" -> awsSdkJsV,
      "@aws-sdk/util-retry" -> awsSdkJsV
    )
  )

lazy val clientDynamodb = project
  .in(file("modules/client-dynamodb"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .dependsOn(core)
  .settings(
    name := "scalajs-awssdk-client-dynamodb",
    commonsSettings,
    testSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies += "@aws-sdk/client-dynamodb" -> awsSdkJsV
  )

lazy val clientS3 = project
  .in(file("modules/client-s3"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .dependsOn(core)
  .settings(
    name := "scalajs-awssdk-client-s3",
    commonsSettings,
    testSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies += "@aws-sdk/client-s3" -> awsSdkJsV
  )

lazy val clientSes = project
  .in(file("modules/client-ses"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .dependsOn(core)
  .settings(
    name := "scalajs-awssdk-client-ses",
    commonsSettings,
    testSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies += "@aws-sdk/client-ses" -> awsSdkJsV
  )

lazy val clientKinesis = project
  .in(file("modules/client-kinesis"))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .dependsOn(core)
  .settings(
    name := "scalajs-awssdk-client-kinesis",
    commonsSettings,
    testSettings,
    scalaJSUseMainModuleInitializer := false,
    Compile / npmDependencies += "@aws-sdk/client-kinesis" -> awsSdkJsV
  )
