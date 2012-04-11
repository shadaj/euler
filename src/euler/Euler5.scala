package euler

// What is the smallest number divisible by each of the numbers 1 to 20?

object Euler5 extends App {
  def divisibleByNums(num: Int): Boolean = {
    (20 to 2 by -1).forall(num % _ == 0)
  }
  
  val foundNum = Iterator.from(2).find(divisibleByNums(_))
  
  // if number does not exist, find will never end anyway
  println(foundNum.get)
}