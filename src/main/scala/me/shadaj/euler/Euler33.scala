package me.shadaj.euler

final class Rational(_num: Long, _den: Long) {
  val commonFactor = Util.gcf(_num, _den)
  val num = _num / commonFactor
  val den = _den / commonFactor

  def *(that: Rational) = {
    new Rational(num * that.num, den * that.den)
  }

  override def equals(o: Any) = {
    o match {
      case that: Rational =>
        num == that.num && den == that.den
      case _ => false
    }
  }

  override def toString = {
    s"$num/$den"
  }
}

object Euler33 extends App {
  val allThatWork = for (digit1 <- 1 to 9; digit2 <- 1 to 9; shared <- 1 to 9) yield {
    val cancelled = new Rational(digit1, digit2)
    Seq(
      new Rational(digit1*10 + shared, digit2*10 + shared),
      new Rational(digit1*10 + shared, shared*10 + digit2),
      new Rational(shared*10 + digit1, digit2*10 + shared),
      new Rational(shared*10 + digit1, shared*10 + digit2)
    ).filter(_ == cancelled)
  }

  println(allThatWork.flatten.filter(f => f.num < f.den).reduce(_ * _).den)
}
