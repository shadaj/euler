package euler

// What is the smallest number divisible by each of the numbers 1 to 20?

object Euler5 extends App {
  def divisibleBy(num: Int): Boolean = {
    (20 to 2 by -1).forall(num % _ == 0)
  }

  var i = 21
  var found = false
  while (!found) {
    if (divisibleBy(i)) {
      found = true
    } else {
      i = i + 1
    }
  }
  println(i)

}