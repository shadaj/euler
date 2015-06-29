package me.shadaj.euler

import scala.annotation.tailrec

object Euler26 extends App {
  def lengthOfCycle(denominator: Int) = {
    @tailrec
    def helper(remainders: Seq[Int], currentRemainder: Int): Int = {
      if (remainders.contains(currentRemainder)) {
        remainders.size - remainders.indexOf(currentRemainder)
      } else {
        helper(remainders :+ currentRemainder,
              (currentRemainder * 10) % denominator)
      }
    }

    helper(Seq[Int](), 1)
  }

  println((1 until 1000).maxBy(lengthOfCycle))
}
