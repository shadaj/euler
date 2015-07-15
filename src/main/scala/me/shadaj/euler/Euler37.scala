package me.shadaj.euler

import Util._

import scala.annotation.tailrec

object Euler37 extends App {
  val allPrimes = sieve(1000000)

  def primePrefixes(num: Int): Boolean = {
    @tailrec
    def helper(cur: Int): Boolean = {
      if (cur == 0) true else {
        if (allPrimes.contains(cur)) helper(cur / 10)
        else false
      }
    }

    helper(num)
  }

  def primeSuffixes(num: Int): Boolean = {
    @tailrec
    def helper(cur: Int): Boolean = {
      if (cur == 0) true else {
        if (allPrimes.contains(cur))
          helper(cur % Math.pow(10, numOfDigits(cur) - 1).toInt)
        else false
      }
    }

    helper(num)
  }

  println((allPrimes - 2 - 3 - 5 - 7).
    filter(n => primePrefixes(n) && primeSuffixes(n)).
    sum)
}
