import mill._, scalalib._

object root extends SbtModule {
  def millSourcePath = ammonite.ops.pwd
  def scalaVersion = "3.1.0"

  object test extends Tests with TestModule.Utest {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.7.10")
  }
}
