package Level_1

import scala.annotation.tailrec

object SmallestMultiple extends App {

  @tailrec
  def trimFactors(index: Int, list: List[Long]): List[Long] =
    if (index <= 0) list
    else {
      val newList: List[Long] =
        list.filter(x => (list(index) % x != 0) || list(index) == x)
      trimFactors(newList.length - (list.length - index - 1) - 2, newList)
    }

  def helper(index: Int, curr: Int, list: List[Long], num: Long): Long =
    if (curr == list.length) num
    else if (num % list(curr) == 0) helper(index, curr + 1, list, num)
    else helper(index + 1, index + 2, list, list.take(index + 1).product)

//  helper(2, 3, trimmed, trimmed.take(2).product)
  def solution(x: Int, y: Int): Long =
    val range: List[Long] = (x to y).toList.map(_.toLong)
//    val trimmed = trimFactors(range.length - 1, range)

    @tailrec
    def etTu(list: List[Long], max: Long, start: Long): Long =
      if (max <= start) -1
      else if (list.exists(start % _ != 0)) etTu(list, max, start + 1)
      else start

    etTu(range, range.product, 1)


  println(solution(11, 20))
}
