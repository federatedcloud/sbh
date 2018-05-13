import mill._
import mill.scalalib._
object sbh extends ScalaModule {
  def scalaVersion = "2.12.6"
  def ivyDeps = Agg(
    //ivy"com.lihaoyi::upickle:0.5.1",
    //ivy"com.lihaoyi::pprint:0.5.2",
    ivy"com.lihaoyi::ammonite-ops:1.1.0",
    ivy"com.lihaoyi::fansi:0.2.5",
    ivy"org.apache.jclouds:jclouds-all:2.1.0",
    //ivy"org.scala-lang:scala-reflect:${scalaVersion()}"
  )
  trait Tests extends super.Tests{
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.6.3")
    def testFrameworks = Seq("utest.runner.Framework")
  }
  object core extends mill.Module {
      object test extends Tests {}
  }
}
