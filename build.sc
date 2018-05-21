import mill._
import mill.define.Target
import mill.scalalib._
import mill.util.Loose
object sbh extends ScalaModule {
  def scalaVersion = "2.12.6"
  val jcloudsVersion = "2.1.0"
  def ivyDeps = Agg(
    ivy"com.lihaoyi::fansi:0.2.5",
  )

  object TestCommon {
    lazy val ivyDeps = Agg(ivy"com.lihaoyi::utest:0.6.3")
    lazy val testFrameworks = Seq("utest.runner.Framework")
  }

  object core extends ScalaModule {
    def scalaVersion = sbh.scalaVersion

    def moduleDeps = Seq(sbh)

    def ivyDeps = Agg(
      ivy"com.lihaoyi::upickle:0.6.6",
      //ivy"com.lihaoyi::pprint:0.5.2",
      ivy"com.lihaoyi::ammonite-ops:1.1.1",
      ivy"com.lihaoyi::fansi:0.2.5",
      ivy"org.apache.jclouds:jclouds-all:$jcloudsVersion",
      ivy"org.apache.jclouds.driver:jclouds-slf4j:$jcloudsVersion",
      //ivy"ch.qos.logback:logback-classic:1.0.13"
      ivy"com.outr::scribe-slf4j:2.4.0",
      //ivy"org.scala-lang:scala-reflect:${scalaVersion()}"
    )

    object test extends Tests {
      def ivyDeps = TestCommon.ivyDeps
      def testFrameworks = TestCommon.testFrameworks
    }
  }
}
