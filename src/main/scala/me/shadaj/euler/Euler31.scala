package me.shadaj.euler

import scala.collection.mutable

object Euler31 extends App {
  val coinValues = List(1, 2, 5, 10, 20, 50, 100, 200)

  val memo = mutable.Map[(Int, Int), Int]()
  def waysToGet(value: Int, maxCoin: Int): Int = {
    if (value < 0) 0
    else if (value == 0) 1
    else {
      memo.getOrElseUpdate((value, maxCoin), {
        coinValues.filter(_ <= maxCoin).map(c => waysToGet(value - c, c)).sum
      })
    }
  }

  println(waysToGet(200, 200))
}
