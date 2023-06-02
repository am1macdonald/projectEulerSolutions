package Level_1

import scala.annotation.tailrec

object EvenFibonacciNumbers extends App {
  val MAX: Long = 4000000
  def getFib: Long = {
    @tailrec
    def helper(p: Long, n: Long, acc: Long): Long = {
      val sum = p + n
      if ((sum) > MAX) acc
      else if ((sum) % 2 == 0) then
        helper(n, sum, acc + sum)
      else
        helper(n, sum, acc)
    }
    helper(1, 1, 0)
  }

  println(getFib)
}

// get next
// check even
// add to accum