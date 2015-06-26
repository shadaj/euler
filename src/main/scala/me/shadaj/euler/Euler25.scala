package me.shadaj.euler

object Euler25 extends App {
  val φ = (1 + Math.sqrt(5)) / 2

  println(Math.ceil((999 + Math.log10(5)/2)/Math.log10(φ)))
}
