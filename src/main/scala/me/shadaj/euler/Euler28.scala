package me.shadaj.euler

object Euler28 extends App {
  def nSquaredSum(n: Int) = (n * (n + 1) * (2*n + 1))/6
  def nSum(n: Int) = (n * (n + 1))/2

  def spiralSum(N: Int) = 16*nSquaredSum(N) + 4*nSum(N) + 4*N + 1

  println(spiralSum(500))
}
