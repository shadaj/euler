package euler

// What is the difference between the sum of the squares and the square of the sums?

object Euler6 {
  def difference = {
    val range = 1 to 100
    val rangeSum = range.sum
    (rangeSum * rangeSum) - range.reduceLeft((a,b) => a + (b * b))
  }

  def main(args: Array[String]): Unit = { 
    println(difference)
  }

}