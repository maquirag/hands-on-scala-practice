import utest._

object Test extends TestSuite {
  def tests = Tests {
    test("Ch03 FizzBuzz 5") {
      val fizz5 = ch03.fizzBuzz(5)
      assert(fizz5 == Seq("1", "2", "Fizz", "4", "Buzz"))
      fizz5
    }
    test("Ch03 FizzBuzz 15th") {
      val fizz15 = ch03.fizzBuzz(15).last
      assert(fizz15 == "FizzBuzz")
      fizz15
    }
  }
}
