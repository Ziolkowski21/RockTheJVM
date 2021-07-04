package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * /      & - bitwise AND, | - bitwise OR
  // ^ bitwise exclusive OR, << >> bitwise left and right shift, >>> right shift with zero extension
  // those are mathematical expressions

  // == != > >= < <= relational expressions

  println(!(1 == x)) // checking if 1 is NOT equal to x
  // ! - logical negation, ||, && - logical expressions

  var aVariable = 2
  aVariable += 3    // take aVariable and add 3 to it, also works with -=, *=, /=, this all are side effects
  println(aVariable)

  // Instructions (Telling computer to DO) vs Expressions (something that has a VALUE and/or a TYPE, give me a value of something)

  // e.g. IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 10 else 3 // if aCondition is true it is equal to 10 otherwise 3
  // it's IF EXPRESSION (not instruction)
  println(aConditionedValue)
  println(if(aCondition) 10 else 3) // compiler is not going to complain because it's expression

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN - loops are specific to imperative programming (java, python, C)

  // EVERYTHING in scala is expression (excepts val, class, package)

  val aWeirdValue = (aVariable = 3) // returns a unit (void in other languages)
  println(aWeirdValue)

  // side effects: println(), whiles, reassigns

  // Code blocks

  val aCodeBlock = {
    val y = 2 // code block can have its own definitions within the code block
    val z = y + 1 // (i.e. y and z aren't visible for the rest)

    if (z > 2) "hello" else "bye"
  }
  println(aCodeBlock) // value of code block is a value of its last expression



  // Questions

  // 1. difference between "hello world" and printl("hello world")
  // 2. what's a value of:

  val someValue = {
    2 < 3
  }

  // 3. what's a value of:

  val someOtherValue ={
    if(someValue) 239 else 986
  }

  // Answers

  // 1. "hello world" is a value of a type string, println("hello world) is an expression which is a side effect
  // its value is a unit
  // 2. boolean false
  // 3. 986 (because someValue is false)
}
