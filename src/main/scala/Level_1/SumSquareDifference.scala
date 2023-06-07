package Level_1

object SumSquareDifference extends App {
  def solution: Int =
    val range = (1 to 100)
    (range.sum * range.sum) -  range.map(x => x * x).sum
  println(solution)
}
