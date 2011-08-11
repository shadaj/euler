package euler
// By considering the terms in the fibonacci sequence whose values
// do not exceed four million, find the sum of the even-valued terms.

object Euler2 extends App {
  def evenFibSum(uptil: Int) = {
    var sum = 0
    var x = 1
    var y = 1
    var numberToAdd = 0
    while (numberToAdd < uptil) {
      numberToAdd = x + y
      if (numberToAdd <= uptil && numberToAdd % 2 == 0) {
        sum += numberToAdd
      }
      x = y
      y = numberToAdd
    }
    sum
  }

  println(evenFibSum(4000000))
}
