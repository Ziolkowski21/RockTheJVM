package lectures.part1basics

object Functions extends App {

  // def aFunction(parameterName: Type, parameterName2: Type2): returnType =
  // implementation (which is single expression (can be block))
  // e.g.

  def aFunction(a: String, b: Int): String =
    a + " " + b   // string concatenation

  println(aFunction("Bob", 2))  // Returns: Bob 2

  // doesn't need parameters
  def aParameterlessFunction(): Int = {
    var a = 42
    a += 5
    a
  }
  println(aParameterlessFunction()) // prints a value i.e. 47
  println(aParameterlessFunction) // works as well

  // recursive function

  def aRepeatedFunction(aString: String, n:Int): String = {   // n - number of repetitions
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3)) // i'm expecting to see hello 3 times

  // WHEN YOU NEED LOOPS USE RECURSION.

  // You can use Unit as a return type
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Welcome") // returns side effects

  // Code blocks allows to use auxiliary functions inside
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }
  println(aBigFunction(5))  // expecting to see 9




}


