package me.shadaj.euler

import Util.lcm

// What is the smallest number divisible by each of the numbers 1 to 20?
object Euler5 extends App {
  val answer = (1 to 20).foldLeft(1L)((a,b) => lcm(a,b))
  println(answer)
}
