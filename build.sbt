val scala3Version = "3.0.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    Compile / doc / scalacOptions += "-snippet-compiler:compile",

    Compile / doc / scalacOptions += 
      "-source-links:" + Seq(
      // Using known provider syntax. Currently github and gitlab are supported
      // "-source-links:<RELATIVE_PATH_PREFIX>=<KNOWN_PROVIDER>://<ORG>/<REPO_NAME>/<REVISION>#<SUBPATH_IN_REPO>"
        "src/main/scala/bar=github://pikinier20/scaladoc_example/main#src/main/scala/bar",
      // Using old Scaladoc syntax. We support `€{FILE_PATH_EXT}`, `€{TPL_NAME}`, `€{FILE_EXT}`, €{FILE_PATH} and €{FILE_LINE}
        "src/main/scala/foo=https://github.com/pikinier20/scaladoc_example/blob/main/src/main/scala/foo€{FILE_PATH_EXT}#L€{FILE_LINE}",
      ).mkString(",") // Source links are delimited with comma
  )
