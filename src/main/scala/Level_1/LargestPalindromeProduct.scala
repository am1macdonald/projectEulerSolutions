package Level_1

import scala.annotation.tailrec

object LargestPalindromeProduct extends App {
  @tailrec
  def isPalindrome[A](list: List[A]): Boolean =
    if (list.length <= 1) true
    else if (list.head == list.last) {
      if (list.length == 2) true
      else isPalindrome(list.tail.dropRight(1))
    } else false

  def isProductOfMagnitude(max: Int, min: Int, num: Int): Boolean =
    if (max <= min) false
    else if (num % max == 0 && (999 >= num / max && num / max >= 100)) true
    else isProductOfMagnitude(max - 1, min, num)

  val max = 999 * 999;
  val min = 100 * 100;

  @tailrec
  def solution(n: Int): Int = {
    if (n < min) -1
    else if (isPalindrome((n).toString.split("").map(_.toInt).toList) && isProductOfMagnitude(999, 100, n)) n
    else solution(n - 1)
  }

  println(solution(max))

}
