name := "rabbitmq-task-generator"

organization := "ardlema"

version := "0.0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "3.2.1",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test" withSources() withJavadoc()
)

initialCommands := "import ardlema.rabbitmqtaskgenerator._"

