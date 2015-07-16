package me.shadaj.euler

object Euler38 extends App {
  def concatenatedPandigital(num: Int): Option[String] = {
    def helper(cur: String, curMultiplier: Int): Option[String] = {
      if (cur.distinct.length != cur.length) None
      else if (cur.length == 9 && cur.min == '1') Some(cur) else {
        helper(cur + (num * curMultiplier).toString, curMultiplier + 1)
      }
    }

    helper(num.toString, 2)
  }

  println((1 to 9999).flatMap(n => concatenatedPandigital(n).map(_.toInt)).max)
}
