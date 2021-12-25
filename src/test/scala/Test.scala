import utest._

object Test extends TestSuite {
  def tests = Tests {
    test("hello") {
      val result = Main.hello()
      assert(result == "Hello Scala")
      result
    }
  }
}
