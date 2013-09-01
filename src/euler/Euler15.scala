package euler

object Euler15 extends App {
  implicit class FactorialInt(val num: Int) extends AnyVal {
    def ! : BigInt = {
      (BigInt(1) to num).product
    }
  }

  println((40!) / ((20!) * (20!)))
}