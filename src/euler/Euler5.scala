package euler

// What is the smallest number divisible by each of the numbers 1 to 20?

object Euler5 {
  def divisibleBy(num: Int): Boolean = {
	  num % 3 == 0 && num % 4 == 0 && num % 5 == 0 && num % 7 == 0 && num % 8 == 0 && num % 9 == 0 && num % 11 == 0 && num % 13 == 0 && num % 16 == 0 && num % 17 == 0 && num % 19 == 0
  }
	
  def main(args: Array[String]): Unit = { 
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

}