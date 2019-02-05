package me.shadaj.euler

// What is the difference between the sum of the squares and the square of the sums?
object Euler6 extends App {
  def difference = {
    val range = 1 to 100
    val sum = range.sum
    val squareSum = range.foldLeft(0)((a, b) => a + (b * b))
    (sum * sum) - squareSum
  }

  println(difference)
}
