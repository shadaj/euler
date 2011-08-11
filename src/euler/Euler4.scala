package euler

// Find the largest palindrome made from the product of two 3-digit numbers

object Euler4 extends App {
  def isPalindrome(num: Int): Boolean = {
    val numString = num.toString
    numString == numString.reverse
  }

  var max: Int = 0
  for (x <- 100 to 999; y <- 100 to 999 if (isPalindrome(x * y) && x * y > max)) {
    max = x * y
  }
  println(max)
}
