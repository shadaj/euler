package me.shadaj.euler

import scala.io.Source

sealed trait Suit
object Clubs extends Suit
object Diamonds extends Suit
object Hearts extends Suit
object Spades extends Suit

case class Card(value: Value, suit: Suit)

sealed class Value(val ordinal: Int) extends Ordered[Value] {
  def compare(that: Value) = ordinal compare that.ordinal
}

object One extends Value(1)
object Two extends Value(2)
object Three extends Value(3)
object Four extends Value(4)
object Five extends Value(5)
object Six extends Value(6)
object Seven extends Value(7)
object Eight extends Value(8)
object Nine extends Value(9)
object Ten extends Value(10)
object Jack extends Value(11)
object Queen extends Value(12)
object King extends Value(13)
object Ace extends Value(14)

object Value {
  val allValuesSorted = Seq(One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace)
}

class Hand(cards: IndexedSeq[Card]) {
  type SubHand = IndexedSeq[Card]
  val royalValues = Seq(Ten, Jack, Queen, King, Ace)
  def isRoyal = {
    if (royalValues.forall(v => cards.exists(_.value == v)))
      Some(cards) else None
  }

  def isRoyalFlush: Option[SubHand] = isRoyal.zip(isFlush).headOption.map(_._1)
  def isStraightFlush: Option[SubHand] = isStraight.zip(isFlush).headOption.map(_._1)
  def isFourOfAKind: Option[SubHand] = cards.groupBy(_.value).find(_._2.size == 4).map(_._2)
  def isFullHouse: Option[SubHand] = isThreeOfAKind.flatMap(t => isOnePair.map(_ => t))
  def isFlush: Option[SubHand] = if (cards.groupBy(_.suit).size == 1) Some(cards) else None

  val possibleStraightValues = Value.allValuesSorted.sliding(5).toSet
  def isStraight: Option[SubHand] = {
    if (possibleStraightValues.contains(cards.map(_.value).sorted)) Some(cards) else None
  }

  def isThreeOfAKind: Option[SubHand] = cards.groupBy(_.value).find(_._2.size == 3).map(_._2)
  def isTwoPairs: Option[SubHand] = {
    val maybePairs = cards.groupBy(_.value).values.filter(_.size == 2)
    if (maybePairs.size == 2) Some(maybePairs.flatten.toIndexedSeq) else None
  }
  def isOnePair: Option[SubHand] = cards.groupBy(_.value).find(_._2.size == 2).map(_._2)

  val rankingCheckers = Seq(
    isRoyalFlush _,
    isStraightFlush _,
    isFourOfAKind _,
    isFullHouse _,
    isFlush _,
    isStraight _,
    isThreeOfAKind _,
    isTwoPairs _,
    isOnePair _
  ).zipWithIndex

  // lower index is better
  lazy val bestRank: Option[(SubHand, Int)] =
    rankingCheckers.view.flatMap(t => t._1().map((_, t._2))).headOption

  lazy val sameValueGroups = cards.groupBy(_.value).map(t => (t._2.size, t._1)).toList.sortBy(_._2).sortBy(_._1)

  lazy val highestValueCards = cards.sortBy(_.value).reverse
}

object Euler54 extends App {
  sealed trait Winner
  object Left extends Winner
  object Right extends Winner

  def betterHand(left: Hand, right: Hand) = {
    val maybeLeftRank = left.bestRank
    val maybeRightRank = right.bestRank

    def compareHighestCard(index: Int = 0): Winner = {
      val bestLeftValue = left.highestValueCards(index).value
      val bestRightValue = right.highestValueCards(index).value
      if (bestLeftValue > bestRightValue) Left
      else if (bestLeftValue < bestRightValue) Right
      else compareHighestCard(index + 1)
    }

    if (maybeLeftRank.isDefined && maybeRightRank.isDefined) {
      if (maybeLeftRank.get._2 < maybeRightRank.get._2) Left
      else if (maybeLeftRank.get._2 > maybeRightRank.get._2) Right
      else {
        val bestLeftRankValue = maybeLeftRank.get._1.maxBy(_.value).value
        val bestRightRankValue = maybeRightRank.get._1.maxBy(_.value).value

        if (bestLeftRankValue > bestRightRankValue) Left
        else if (bestLeftRankValue < bestRightRankValue) Right
        else compareHighestCard()
      }
    } else if (maybeLeftRank.isDefined ^ maybeRightRank.isDefined) {
      if (maybeLeftRank.isDefined) Left else Right
    } else {
      compareHighestCard()
    }
  }

  def parseCard(card: String) = {
    val value = card.head match {
      case 'J' => Jack
      case 'Q' => Queen
      case 'K' => King
      case 'A' => Ace
      case 'T' => Ten
      case n => Value.allValuesSorted(n.asDigit - 1)
    }

    val suit = card.last match {
      case 'H' => Hearts
      case 'C' => Clubs
      case 'S' => Spades
      case 'D' => Diamonds
    }

    Card(value, suit)
  }

  val lines = Source.fromFile("p054_poker.txt").getLines()
  val answer = lines.count { l =>
    val cards = l.split(' ').map(parseCard).toIndexedSeq
    val left = new Hand(cards.take(5))
    val right = new Hand(cards.drop(5))

    val better = betterHand(left, right)
    better == Left
  }

  println(answer)
}
