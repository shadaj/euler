package euler

// What is the difference between the sum of the squares and the square of the sums?

object Euler6 extends App {
  def difference = {
    val range = 2 to 3
    val sum = range.sum
    val squareSum = range.foldLeft(0)((a, b) => a + (b * b))
    (sum * sum) - squareSum
  }

  println(difference)
}




