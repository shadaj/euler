package me.shadaj.euler

import scala.annotation.tailrec

object Euler40 extends App {
  @tailrec
  def numberAt(i: Int, digits: Int): Int = {
    val fromPower = Math.pow(10, digits - 1).toInt * 9 * digits
    if (i < fromPower) {
      val numberIndex = i / digits
      val digitIndex = i % digits
      (Math.pow(10, digits - 1) + numberIndex).toString()(digitIndex).asDigit
    } else {
      numberAt(i - fromPower, digits + 1)
    }
  }

  println((0 to 6).map(Math.pow(10, _).toInt).map(n => numberAt(n - 1, 1)).product)
}
