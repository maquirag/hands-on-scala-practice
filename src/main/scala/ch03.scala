import java.nio.file.Files
import java.nio.file.Paths
import java.io.BufferedWriter
import java.io.BufferedReader
object ch03 {
  def fizzBuzz(upto: Int): Seq[String] = {
    Range
      .inclusive(1, upto)
      .map(num =>
        num match {
          case n if n % 15 == 0 => "FizzBuzz"
          case n if n % 3 == 0  => "Fizz"
          case n if n % 5 == 0  => "Buzz"
          case _                => num.toString
        }
      )
  }

  def flexibleFizzBuzz(process: String => Unit) = {
    for s <- fizzBuzz(15) do process(s)
  }

  class Msg(val id: Int, val parent: Option[Int], val txt: String)

  def printMessages(messages: Array[Msg]): Unit = {
    def printFrag(parent: Option[Int], indent: String): Unit = {
      for (msg <- messages if msg.parent == parent) {
        println(s"$indent#${msg.id} ${msg.txt}")
        printFrag(Some(msg.id), indent + "  ")
      }
    }
    printFrag(None, "")
  }

  def withFileWriter[T](file: String)(handle: BufferedWriter => T) = {
    val f = Files.newBufferedWriter(Paths.get(file))
    try handle(f)
    finally f.close
  }

  def withFileReader[T](file: String)(handle: BufferedReader => T) = {
    val f = Files.newBufferedReader(Paths.get(file))
    try handle(f)
    finally f.close
  }

}
