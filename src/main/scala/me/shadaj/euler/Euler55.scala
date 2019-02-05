package me.shadaj.euler

// https://projecteuler.net/problem=55
object Euler55 extends App {
  def isLychrel(currentNum: BigInt, remainingIterations: Int = 50): Boolean = {
    if (remainingIterations == 0) true else {
      val next = BigInt(currentNum.toString.reverse) + currentNum
      if (next.toString.reverse == next.toString) false else {
        isLychrel(next, remainingIterations - 1)
      }
    }
  }

  println((1 until 10000).count(isLychrel(_)))
}
