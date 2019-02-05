package me.shadaj.euler

import scala.io.Source

object Euler1867 extends App {
  val source = Source.fromFile("prob67.txt").getLines
  val pyramid = source.map(_.split(" ")).map(_.map(_.toInt)).toIndexedSeq

  val maxes = collection.mutable.Map[(Int, Int), Int]()

  def maxValue(i: Int, j: Int): Int = {
    if (i == pyramid.length) {
      0
    } else {
      maxes.getOrElseUpdate((i, j),
        pyramid(i)(j) + (maxValue(i + 1, j) max maxValue(i + 1, j + 1)))
    }
  }

  println(maxValue(0, 0))
}
