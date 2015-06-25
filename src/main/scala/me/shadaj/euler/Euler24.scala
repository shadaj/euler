package me.shadaj.euler

import Util._

object Euler24 extends App {
  def nthPermutation(n: Int, digits: Seq[Int]): Seq[Int] = {
    if (digits.size == 1) {
      digits
    } else {
      val groupSize = ((digits.length - 1)!).toInt
      val groupI = n / groupSize
      val withinGroup = n % groupSize
      digits(groupI) +: nthPermutation(withinGroup, digits.filterNot(_ == digits(groupI)))
    }
  }

  println(nthPermutation(999999, 0 to 9).mkString)
}
