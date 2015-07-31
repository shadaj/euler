package me.shadaj.euler

object Euler49 extends App {
  val DIFF = 3330
  val NUMBER_SIZE = 4
  val PREVIOUS_FOUND = 1487

  def seqFrom(start: Int) = {
    Seq(start, start + DIFF, start + DIFF*2)
  }

  def works(start: Int) = {
    val seq = seqFrom(start)
    val sortedDigits = seq.map(_.toString.sorted).distinct

    sortedDigits.size == 1 &&
      sortedDigits.head.length == NUMBER_SIZE &&
      seq.forall(n => Util.isPrime(n.toLong))
  }

  println(Iterator.from(PREVIOUS_FOUND + 1).find(works).map(seqFrom(_).mkString).get)
}
