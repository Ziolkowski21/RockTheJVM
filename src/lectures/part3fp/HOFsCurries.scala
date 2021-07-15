package lectures.part3fp

// Higher Order Functions and Curries

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean) => Int) => (Int => Int)) = null
  // return type of this function is another function which takes int and returns int
  // parameters Int and function (String, (Int => Boolean) => Int)
  // then (String, (Int => Boolean) => Int) is another function that String and function (Int => Boolean) are parameters
  // and returns Int
  // Higher-Order-Function (HOF)

  // function that applies a function f n times over a value x
  // nTimes(f,n,x)
  // nTimes(f,3,x) = f(f(f(x))) = nTimes(f,2,f(x)) = nTimes(f, 1, f(f(x)))
  // nTimes(f,n,x) = f(f(...(x))) =nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))
  // nTimes(x+1, 3, 1) = nTimes(x+1, 2, (x+(1+1))) = nTimes(x+1, 1, (x+(1+(1+1)) = nTimes(x+1, 0, (x+1+(1+(1+1)))) = 4

  // nTimesBetter(f,n) = x => f(f(f...(x))))
  // increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne... (x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x)) // returns a function that will be applied to f(x)

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))
  // plus10(1) = nTimesBetter(plusOne, 10)

  // curried functions
  val superAdder = (x: Int) => (y: Int) => x + y  // superAdder: Int => Int => Int but technically : Int => (Int => Int)
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10)) // 3 + 10
  println(superAdder(3)(10))

  // functions with multiple parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)
  // now i can define a function with multiple parameter list to act like curried function and create various formatings

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")  // types must be specified for it to work
  println(standardFormat(Math.PI))  // 3.14
  println(preciseFormat(Math.PI))   // 3.14159265
}
