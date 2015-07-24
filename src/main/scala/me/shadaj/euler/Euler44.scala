package me.shadaj.euler

object Euler44 extends App {
  def pentagonal(i: Int) = i * ((3 * i) - 1) / 2

  val isPentagonal = Iterator.from(1).map(pentagonal).
    takeWhile(_ >= 0).toSet

  var best = Int.MaxValue

  for (i1 <- 1 to isPentagonal.size) {
    val p1 = pentagonal(i1)
    val p2s = (i1 - 1 to 1 by -1).view.map(pentagonal)
    p2s.takeWhile(p1 - _ < best).
        find(p2 => isPentagonal(p1 + p2) && isPentagonal(p1 - p2)).
        foreach(p2 => best = p1 - p2)
  }

  println(best)
}
