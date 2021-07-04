package exercises.part1basics

object Functions extends App{

  /*
  1. A greeting function (name, age) -> "Hi, my name is [] and I am [] years old
  2. Factorial function: n! = 1!+2!+3!...+n!
  3. Fibonacci function:
    f(1) = 1
    f(2) = 1
    f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
   */


  // 1.
  def greetings(name: String, age: Int): Unit = {
    var str1 = "Hi, my name is "
    var str2 = " and I am "
    var str3 = " years old"
    println(str1 + name + str2 + age + str3)
  }
greetings("Bob", 5000)

  // 2.
  def factorial(n: Int): Int = {
    if (n == 1) n
    else if (n == 0) 1
    else n * factorial(n-1)
  }
  println(factorial(4))

  // 3.
//  def fibonacci(n: Int): Int = {
//    var n1 = 0
//    var n2 = 1
//    def fibonacci
//
//    if (n == 1) n
//    else fibonacci(n-1) + fibonacci(n-2)
//  }

//  // 4.
//  def prime(n: Int): Boolean = {
//    if n % (n+1)
//  }


  // Solutions:
  // 1

  def greetingsForKids(name: String, age: Int): String =
    "Hi my name is " + name + " " + "and I am " + age + " years old"
  println(greetingsForKids("David", 5))

  // 2

  def factorial2(n: Int): Int =
    if (n <= 0) 1
    else n * factorial2(n-1)

  println(factorial2(5))

  // 3

  def fibonacci2(n: Int): Int =
    if(n <= 2) 1
    else fibonacci2(n-1) + fibonacci2(n-2)

  // 1 1 2 3 5 8 13 21...
  println(fibonacci2(8))

  // 4.

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =   // does n have any dividers until t
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(4))
}



