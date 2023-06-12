package Level_1

import scala.annotation.tailrec
import scala.io.Source

object LargestProductInASeries extends App {

  val seriesSource: String = "largestProductSet.txt"
  val windowWidth: Int = 13
  def solution(): Long = {

    val source = Source.fromResource(seriesSource)
    val stream = try source.getLines().mkString finally source.close();

    @tailrec
    def helper(list: List[Int], max: Long): Long = {
      val product = list.take(windowWidth).map(_.toLong).product
      if(list.length < windowWidth) max
      else helper(list.drop(1),  List(max, product).max)
    }

    helper(stream.split("").toList.map(_.toInt), -1)
  }

  println(solution())

}
