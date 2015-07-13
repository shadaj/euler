package me.shadaj.euler

import Util._

object Euler35 extends App {
  val max = 1000000

  def maybeCircular(num: Int) = {
    digits(num).forall(d => !(d % 2 == 0 || d == 5))
  }

  val primesToMillion = sieve(max)

  val maybeCircularPrimes = Seq(2, 5) ++ primesToMillion.filter { num =>
    maybeCircular(num)
  }

  val powerBumps = (0 until numOfDigits(max) - 1).map(Math.pow(10, _).toInt)

  val ans = maybeCircularPrimes.count { num =>
    var curNum = num
    val digitsCount = numOfDigits(num)
    val powerBump = powerBumps(digitsCount - 1)
    (1 until digitsCount).forall { _ =>
      curNum = (curNum / 10) + ((curNum % 10) * powerBump)
      primesToMillion.contains(curNum)
    }
  }

  println(ans)
}
