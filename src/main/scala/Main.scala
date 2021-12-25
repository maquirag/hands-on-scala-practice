import ch03.*
object Main {
  def main(args: Array[String]): Unit = {
    check_chapter03
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
}
