package euler
// By considering the terms in the fibonacci sequence whose values
// do not exceed four million, find the sum of the even-valued terms.

object Euler2 extends App {
  def nextFib(x: Int, y: Int): Stream[Int] = {
    x #:: nextFib(y, x+y)
  }

  def fib = nextFib(1,1)
  println(fib.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum)
}
