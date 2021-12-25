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
}
