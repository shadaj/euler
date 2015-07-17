package me.shadaj.euler

object Euler39 extends App {
  /*
    perimeter = a + b + c
    c = perimeter - a - b
    a^2 + b^2 = (perimeter - (a + b))^2
    a^2 + b^2 = perimeter^2 - 2*perimeter*(a + b) + a^2 + 2ab + b^2
    2*perimeter*a + 2*perimeter*b = perimeter^2 + 2ab
    b*(2*perimeter - 2a) = perimeter^2 - 2*perimeter*a
    b = perimeter*(perimeter - 2a)/2*(perimeter - a)
  */

  def solutionsCount(p: Int) = {
    (1 to p/2).count { a =>
      val bNum = p * (p - 2*a)
      val bDen = 2*(p - a)
      bNum % bDen == 0 && a <= (bNum/bDen)
    }
  }

  println((1 to 1000).maxBy(solutionsCount))
}
