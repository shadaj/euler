package me.shadaj.euler

object Euler52 extends App {
  println(Iterator.from(1).find(n => (2 to 6).map(m => (n * m).toString.sorted).distinct.size == 1).get)
}
