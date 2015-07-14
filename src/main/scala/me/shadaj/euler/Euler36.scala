package me.shadaj.euler

object Euler36 extends App {
  val max = 1000000

  val allThatWork = (1 to max).filter { n =>
   {
     val numString = n.toString
     numString == numString.reverse
   } && {
     val binaryString = n.toBinaryString
     binaryString == binaryString.reverse
   }
  }

  println(allThatWork.sum)
}
