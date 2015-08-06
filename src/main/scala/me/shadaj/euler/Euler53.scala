package me.shadaj.euler

object Euler53 extends App {
  def pascalsTriangle(currentRow: Vector[Option[Int]]): Stream[Vector[Option[Int]]] = {
    val nextRow = Some(1) +: currentRow.sliding(2).map { s =>
      if (s.exists(_.isEmpty)) None else {
        val sum = s.head.get + s.last.get
        if (sum > 1000000) None else Some(sum)
      }
    }.toVector :+ Some(1)

    currentRow #:: pascalsTriangle(nextRow)
  }

  println(pascalsTriangle(Vector(Some(1))).take(100).flatten.count(_.isEmpty))
}
