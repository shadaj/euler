package me.shadaj.euler

object Euler32 extends App {
  def split(aLen: Int, bLen: Int, digits: Seq[Int]) = {
    (digits.take(aLen), digits.slice(aLen, aLen + bLen), digits.drop(aLen + bLen))
  }

  val cases = (1 to 9).permutations.flatMap { digits =>
    Seq(
      split(1, 4, digits),
      split(2, 3, digits)
    )
  }

  def seqToInt(seq: Seq[Int]) = {
    seq.reduce((prev, cur) => prev * 10 + cur)
  }

  println(cases.filter(t => seqToInt(t._1) * seqToInt(t._2) == seqToInt(t._3)).
    map(t => seqToInt(t._3)).toList.distinct.sum)
}
