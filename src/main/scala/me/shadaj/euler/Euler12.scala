package me.shadaj.euler

import Util._

object Euler12 extends App {
	def factorCount(num: Long): Long = {
	  primeFactors(num).groupBy(identity).map(_._2.length + 1).product
	}
	
	def triangleNumber(x: Int): Int = {
	  if (x == 0) 0
	  else x + triangleNumber(x - 1)
	}
	
	val triangleNumbers = Iterator.from(1).map(triangleNumber)
	
	println(triangleNumbers.find(factorCount(_) > 500).get)
}
