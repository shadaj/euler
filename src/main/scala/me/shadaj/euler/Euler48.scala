package me.shadaj.euler

object Euler48 extends App {
  val modder = Math.pow(10, 10).toLong
  val sum = (1 to 1000).map { i =>
    (2 to i).foldLeft(i.toLong)((acc, _) => (acc * i) % modder)
  }.sum % modder

  println(sum)
}
