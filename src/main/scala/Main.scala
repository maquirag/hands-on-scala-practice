import ch03.*
import ch04.*
import ch05.*

object Main {
  def main(args: Array[String]): Unit = {
    //check_chapter03
    check_chapter05
  }

  def check_chapter03 = {
    // Chapter 3
    println(fizzBuzz(15))
    var i = 0
    val output = new Array[String](15)
    flexibleFizzBuzz { s =>
      output(i) = s
      i += 1
    }
    println(output.toList)
    flexibleFizzBuzz(s => {})
    flexibleFizzBuzz(s => println(s))
    println("-".repeat(30))
    printMessages(
      Array(
        new Msg(0, None, "Hello"),
        new Msg(1, Some(0), "World"),
        new Msg(2, None, "I am Cow"),
        new Msg(3, Some(2), "Hear me moo"),
        new Msg(4, Some(2), "Here I stand"),
        new Msg(5, Some(2), "I am Cow"),
        new Msg(6, Some(5), "Here me moo, moo")
      )
    )
  }

  def check_chapter05 = {
    val ex1 = BinOp(Variable("x"), "+", Literal(1))
    println(stringify(ex1))
    val ex2 = BinOp(
      Variable("x"),
      "*",
      BinOp(Variable("y"), "-", Literal(1))
    )
    println(stringify(ex2))
    val ex3 = BinOp(
      BinOp(Variable("x"), "+", Literal(1)),
      "*",
      BinOp(Variable("y"), "-", Literal(1))
    )
    println(stringify(ex3))
  }
}
