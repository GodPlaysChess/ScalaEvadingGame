name := "SimpleGame"

version := "1.0"

scalaVersion := "2.10.4"

addCommandAlias("generate-project",
  ";update-classifiers;update-sbt-classifiers;gen-idea sbt-classifiers")

libraryDependencies += "org.lwjgl.lwjgl" % "lwjgl" % "2.9.1" withSources() withJavadoc()

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"

libraryDependencies += "commons-codec" % "commons-codec" % "1.6"

scalacOptions in(Compile, doc) := Seq("-groups", "-implicits")

//addCommandAlias("generate-project", "update-classifiers; update-sbt-classifiers; gen-idea sbt-classifiers")

//addCommandAlias("generate-project", ";update-classifiers;gen-idea")

//libraryDependencies += "org.newdawn" % "slick" % "274" from "Slick Repository"


