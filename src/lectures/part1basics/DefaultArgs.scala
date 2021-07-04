package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int): Int = // accumulator here pollutes the implementation (as for 99% of the time acc = 1)
    if (n <= 1) acc
    else trFact(n - 1, acc * n)

  @tailrec
  def trFact2(n: Int, acc: Int = 1): Int = // that's why you can set default parameter (if acc not passed it's gonna
    if (n <= 1) acc                         // assume it's one
    else trFact2(n - 1, acc * n)

  val fact10 = trFact(10, 1)
  val fact10_2 = trFact2(10)

  println(fact10_2 == fact10)

  // however, default parameters create additional challenges, e.g. for this arbitrary function:

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  /* savePicture(800, 1080) is assuming that first parameter is supposed to be 800 which would create an error due to
   type conflict

  2 Solutions:
    1. Pass in every leading argument: savePicture("jpg", 500, 300) OR savePicture()
    2. name the arguments: savePicture(width = 800)
  */

}
