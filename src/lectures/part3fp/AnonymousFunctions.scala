package lectures.part3fp

object AnonymousFunctions extends App{

  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  } // that's object oriented way of defining an anonymous function and instantiating it on the spot

  // but can also use anonymous function (LAMBDA)"
  val tripler = (x: Int) => x * 3
  val tripler2: Int => Int = x => x * 3 // the type Int => Int is given and hence no need of specifying x type

  println(doubler(3), tripler(2))

  // multiple params in lambda
  val adder = (x: Int, y: Int) => x + y
  val adder2: (Int, Int) => Int = (x, y) => x + y

  // no params
  val justDoSomething = () => 3
  val justDoSomething2: () => Int = () => 3

  println(justDoSomething)   // prints function itself
  println(justDoSomething()) // prints evaluation of function (call)

  // Curly braces with lambda
  val stringToInt = { (str: String) => // parameter types
    str.toInt // implementation
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  niceIncrementer(2)
  val nicerIncrementer: Int => Int = _ + 1

  val nicerMultipleParamIncrementer: (Int, Int) => Int = _ + _


}
