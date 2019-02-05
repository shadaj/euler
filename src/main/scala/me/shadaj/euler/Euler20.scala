package me.shadaj.euler

import Util._

import scala.annotation.tailrec

object Euler20 extends App {
  val factorialNum = 100!

  println(factorialNum.toString().map(_.asDigit).sum)
}
