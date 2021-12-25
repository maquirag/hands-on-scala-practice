import utest._
import ch03.*

object Test extends TestSuite {
  def tests = Tests {
    // Chapter 3
    test("Ch03 FizzBuzz 5") {
      val fizz5 = fizzBuzz(5)
      assert(fizz5 == Seq("1", "2", "Fizz", "4", "Buzz"))
      fizz5
    }
    test("Ch03 FizzBuzz 15th") {
      val fizz15 = fizzBuzz(15).last
      assert(fizz15 == "FizzBuzz")
      fizz15
    }
    test("Ch03 FizzBuzz Flexible, allocate") {
      var i = 0
      val output = new Array[String](30)
      flexibleFizzBuzz { s =>
        output(i) = s
        i += 1
      }
      assert(
        output.toSeq.take(5) == Seq[String]("1", "2", "Fizz", "4", "Buzz")
      )
      output.toSeq
    }
    test("Ch03 File Context Manager") {
      withFileWriter("File.txt") { writer =>
        writer.write("Hello\n")
        writer.write("World!")
      }
      val result = withFileReader("File.txt") { reader =>
        reader.readLine() + "\n" + reader.readLine()
      }
      assert(result == "Hello\nWorld!")
      result
    }
  }
}
