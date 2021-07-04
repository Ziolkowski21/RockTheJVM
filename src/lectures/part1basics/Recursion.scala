package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n<=0) 1
    else {
      println("Computing factorial of " + n + " - I first need a factorial of " (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  factorial(10)
  // factorial(5000) // gonna result in stack overflow, need to write a code in more "smart way"

  def anotherFactorial(n: Int): BigInt ={
    @tailrec // tells compiler that this function is supposed to be tail recursive (optional)
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION - use recursive call as the LAST expression

    factHelper(n, 1)
  }
  /*
  anotherFactorial(10) = factHelper(10, 1)    - is 10 less than 1? no, hence:
    = factHelper(9, 10 * 1)                   - 9 <= 1?, no, hence:
    = factHelper(8, 9 * 10 * 1)                - 8 <= 1?, no hence:
    .
    .
    = factHelper(2, 3 * 4 * ... * 9 * 10 * 1)   is 2 <= 1? no, therefore:
    = factHelper(1, 2 * 3 * ... * 9 * 10 * 1)   is 1 <= 1? yes, therefore:
    = accumulator = 2 * 3 * ... * 9 * 10 * 1
   */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS USE TAIL RECURSION
}
