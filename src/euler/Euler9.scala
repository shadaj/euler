package euler

//A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
//
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

object Euler9 extends App {
  def pythagoreanTripletForSum(sum: Int): Seq[(Int, Int, Int)] = {
    val triplets = for {a <- 1 to sum; b <- 1 to sum; c <- 1 to sum - a - b 
    	if a * a + b * b == c * c && a + b + c == sum && a < b && b < c} yield (a,b,c)
    triplets
  }
  
  val triplet = pythagoreanTripletForSum(1000).head
  println(triplet._1 * triplet._2 * triplet._3)
}