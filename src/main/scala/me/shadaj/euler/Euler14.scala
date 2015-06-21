package me.shadaj.euler

import scala.annotation.tailrec

object Euler14 extends App {
  def seriesLength(start: Long): Long = {
    @tailrec
    def loop(n: Long, length: Long): Long = {
      if (n == 1) length + 1
      else if (n % 2 == 0) loop(n / 2, length + 1)
      else loop(3*n + 1, length + 1)
    }
    loop(start, 0)
  }

  val answer = (1L to 1000000).par.maxBy(seriesLength)
  println(answer)
}