package Level_1

import scala.annotation.tailrec

object LargestPrimeFactor extends App {

  def solution(target: Long): Long = {
    @tailrec
    def helper(n: Int, target: Long): Long = {
      println(target)
      if (n > target) 1
      else if (target % n == 0)
        if ((n * n) >= target / n) target / n
        else helper(n + 1, target / n)
      else helper(n + 1, target)
    }

    helper(2, target)
  }


  println(solution(13195))
  println(solution(600851475143L))
}
