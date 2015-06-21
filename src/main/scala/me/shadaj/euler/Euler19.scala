package me.shadaj.euler

import scala.annotation.tailrec

object Euler19 extends App {
  val daysInMonth = List(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  
  def isLeapYear(year: Int) = {
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
  }
  
  def daysInMonth(month: Int, year: Int): Int = {
    daysInMonth(month) + (if (isLeapYear(year) && month == 1) 1 else 0)
  }
  
  @tailrec
  def countSundays(month: Int, year: Int, dayOfWeek: Int, count: Int, endYear: Int): Int = {
    if (year == endYear) {
      count
    } else {
      val newDay = (dayOfWeek + daysInMonth(month, year)) % 7
      val newCount = if (dayOfWeek == 0) count + 1 else count
      val newMonth = (month + 1) % 12
      val newYear = year + ((month + 1)/12)
      countSundays(newMonth, newYear, newDay, newCount, endYear)
    }
  }

  println(countSundays(0, 1901, 2, 0, 2001))
}