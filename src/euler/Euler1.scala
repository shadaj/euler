package euler

// Add all the natural numbers below one thousand that are multiples of 3 or 5.
object Euler1 extends App {
  
    val sum = (1 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).sum
    println(sum)

}
