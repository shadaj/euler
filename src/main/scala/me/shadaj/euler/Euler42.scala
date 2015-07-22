package me.shadaj.euler

import scala.io.Source

object Euler42 extends App {
  val words = Source.fromFile("p042_words.txt").getLines().next().split(',').map(_.tail.init)

  def wordSum(word: String) = {
    word.map(c => c - 'A' + 1).sum
  }

  val answer = words.count { w =>
    val sum = wordSum(w)
    val root = Math.sqrt(sum * 2).toInt
    root * (root + 1) == sum * 2
  }

  println(answer)
}
