import scala.quoted.Expr
object ch05 {
  sealed trait Expr
  case class BinOp(left: Expr, op: String, right: Expr) extends Expr
  case class Literal(value: Int) extends Expr
  case class Variable(name: String) extends Expr

  def stringify(expr: Expr): String = expr match {
    case BinOp(left, op, right) =>
      s"(${stringify(left)} $op ${stringify(right)})"
    case Literal(value) => value.toString
    case Variable(name) => name
  }

  def eval(expr: Expr, values: Map[String, Int]): Int = expr match {
    case BinOp(left, op, right) =>
      op match {
        case "+" => eval(left, values) + eval(right, values)
        case "-" => eval(left, values) - eval(right, values)
        case "*" => eval(left, values) * eval(right, values)
      }
    case Literal(value) => value
    case Variable(name) => values(name)
  }
}
