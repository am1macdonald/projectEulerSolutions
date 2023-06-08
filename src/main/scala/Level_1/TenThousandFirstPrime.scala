package Level_1

import scala.annotation.tailrec

object TenThousandFirstPrime extends App {

  //  def sieve(list: Set[Long]): Set[Long] =
  //    @tailrec
  //    def helper(list: Set[Long], index: Int): Set[Long] =
  //      if (index >= list.) list
  //      else helper(list.filter(x => (list(index) == 1 || x == list(index) || x % list(index) > 0)), index + 1)
  //    helper(list, 0)
  //  def solution: Long =
  //    sieve((1 to 10000000).map(_.toLong).toSet).length

  def numberStream(n: Int):
  Stream[Int] = Stream.from(n)

  def sieve_of_Eratosthenes(stream: Stream[Int]):
  Stream[Int] = stream.head #:: sieve_of_Eratosthenes(
    (stream.tail)
      filter (x => x % stream.head != 0)
  )

  val no_of_primes = sieve_of_Eratosthenes(numberStream(2))

  (no_of_primes drop 10000 take 1) foreach {
    println(_)
  }

  // tried using plain lists but it took too long
  // Implementation borrowed from...
  // https://www.geeksforgeeks.org/scala-sieve-of-eratosthenes/
}
