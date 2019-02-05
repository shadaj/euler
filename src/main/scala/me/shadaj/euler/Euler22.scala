package me.shadaj.euler

import scala.io.Source

object Euler22 extends App {
  val A = 'A'.toInt
  def wordPoints(word: String) = {
    word.map(c => (c.toInt - A) + 1).sum
  }
  
  val source = Source.fromFile("p022_names.txt").getLines().next().split(',').map(_.tail.init).sorted
  val answer = source.zipWithIndex.map { case (s, i) =>
    wordPoints(s) * (i + 1)
  }.sum
  
  println(answer)
}
