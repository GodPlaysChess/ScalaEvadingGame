name := "SimpleGame"

version := "1.0"

libraryDependencies += "org.lwjgl.lwjgl" % "lwjgl" % "2.9.1" withSources() withJavadoc()

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"
//
//resolvers += "Slick Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository/"
//
//libraryDependencies += "org.newdawn" % "slick" % "274" from "Slick Repository"

