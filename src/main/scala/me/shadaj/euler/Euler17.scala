package me.shadaj.euler

object Euler17 extends App {
  val ones = List("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
  val tens = List("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
  val elevenNineteen = List("eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

  def twoDigits(num: Int) = {
    if (num / 10 == 0) {
      ones(num)
    } else if (num > 10 && num < 20) {
      elevenNineteen(num % 11)
    } else {
      val tensPlace = num / 10
      val onesPlace = num % 10

      s"${tens(tensPlace)} ${ones(onesPlace)}"
    }
  }

  def threeDigits(num: Int) = {
    if (num / 100 == 0) {
      twoDigits(num)
    } else {
      val twodigits = twoDigits(num % 100)
      s"${ones(num / 100)} hundred" + " " + {
        if (twodigits.nonEmpty) {
          "and "
        } else {
          ""
        }
      } + twodigits
    }
  }
  
  def number(num: Int) = {
    if (num/1000 == 0) {
      threeDigits(num)
    } else {
      "one thousand" // One thousand is the max
    }
  }

  println((1 to 1000).map(number(_).filter(_ != ' ').length).sum)
}
