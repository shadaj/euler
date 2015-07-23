package me.shadaj.euler

object Euler43 extends App {
  def works(pandigital: String) = {
    val slid = pandigital.tail.sliding(3)
    slid.zip(Iterator(2, 3, 5, 7, 11, 13, 17)).forall { case (slidStr, divisible) =>
      slidStr.toInt % divisible == 0
    }
  }

  println((0 to 9).mkString.permutations.filter(works).map(_.toLong).sum)
}
