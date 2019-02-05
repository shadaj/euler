package me.shadaj.euler

//A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
//
//a^2 + b^2 = c^2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
object Euler9 extends App {
  def tripletForSum(sum: Int) = {
    val triplets = for (a <- (1 to sum).view;
    b <- 1 to sum - a;
    c <- 1 to sum - a - b if (isTriplet(a,b,c,sum))) yield (a,b,c)
    triplets.head
  }
  
  def isTriplet(a: Int, b: Int, c: Int, sum: Int) = {
    (a*a) + (b*b) == (c*c) && a + b + c == sum && a < b && b < c
  }
  
  val answerTriplet = tripletForSum(1000)
  println(answerTriplet)
  val answer = answerTriplet._1 * answerTriplet._2 * answerTriplet._3
  println(answer)
}
