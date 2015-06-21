package me.shadaj.euler

object Euler16 extends App {
  val twoPower = BigInt(2).pow(1000)
  
  val answer = twoPower.toString.map(_.asDigit).sum
  println(answer)
}