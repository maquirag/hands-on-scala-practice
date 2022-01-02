import utest._
import ch03.*
import ch04.*
import ch05.*

object HandsOn extends TestSuite {
  def tests = Tests {
    test("ch03") {
      // Chapter 3
      test("fizz5") {
        val fizz5 = fizzBuzz(5)
        assert(fizz5 == Seq("1", "2", "Fizz", "4", "Buzz"))
        fizz5
      }
      test("fizz15") {
        val fizz15 = fizzBuzz(15).last
        assert(fizz15 == "FizzBuzz")
        fizz15
      }
      test("fizzbuzz") {
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
      test("context_manager") {
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

    test("ch05") {
      test("stringify_simple_expr") {
        val op = BinOp(Variable("x"), "+", Literal(1))
        val s = stringify(op)
        assert(s == "(x + 1)")
        s
      }
      test("stringify_combo_expr") {
        val op = BinOp(
          BinOp(Variable("x"), "+", Literal(1)),
          "*",
          BinOp(Variable("y"), "-", Literal(1))
        )
        val s = stringify(op)
        assert(s == "((x + 1) * (y - 1))")
        s
      }
      test("evaluate_x_plus_1") {
        val op = BinOp(Variable("x"), "+", Literal(1))
        val result = eval(op, Map("x" -> 41))
        assert(result == 42)
        result
      }
      test("evaluate_(x+1)*(y-1)") {
        val op = BinOp(
          BinOp(Variable("x"), "+", Literal(1)),
          "*",
          BinOp(Variable("y"), "-", Literal(1))
        )
        val result = eval(op, Map("x" -> 2, "y" -> 5))
        assert(result == 12)
        result
      }
      test("simplify_(((1 + 1) * y) + ((1 - 1) * x))") {
        val op = BinOp(
          BinOp(
            BinOp(Literal(1), "+", Literal(1)),
            "*",
            Variable("y")
          ),
          "+",
          BinOp(BinOp(Literal(1), "-", Literal(1)), "*", Variable("x"))
        )
        val result = simplify(op)
        assert(result == BinOp(Literal(2), "*", Variable("y")))
        stringify(result)
      }
    }
  }
}
