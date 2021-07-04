package exercises.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  /*
  1. Concatenate a string n times with tail recursion
  2. IsPrime function with tail recursive
  3. Fibonacci tail recursive
   */

  // 1.

  def conc(x: Int, str: String): String = {
    @tailrec
    def helper(n: Int,  accumulator: String): String =
      if (n <= 1) accumulator
      else helper(n - 1, accumulator + str)

    helper(x, str)

  }

  println(conc(10, "Hello "))

  // 2.

//  def IsPrime(n: Int): Boolean = {
//    @tailrec
//    def go(x: Int, 1)
//  }

  // 3.

//def Fibonacci(n: Int): Int ={
//  @tailrec
//  def FibonacciGo(t: Int, accumulator1: Int, accumulator2: Int): Int = {
//    if (t <= 2) 1
//    else FibonacciGo(t-1, )
//  }
//}





  // SOLUTIONS:

  // 1.

  @tailrec
  def concatanateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatanateTailRec(aString, n - 1, aString + accumulator)

  println(concatanateTailRec("Hello", 5, ""))

  // 2.
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeGo(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeGo(t - 1, n % t != 0 && isStillPrime)

    isPrimeGo(n / 2, true)
  }

  println(isPrime(10))

  // 3.

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciGo(i: Int, last: Int, nextToLast: Int): Int = {  // last and nextToLast are technically accumulators
      if (i >= n) last
      else fibonacciGo(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fibonacciGo(2, 1, 1) // number 2 is 3rd number in Fibonacci series
  }

  // 1 1 2 3 5 8 13 21 ...
  println(fibonacci(8))
}
