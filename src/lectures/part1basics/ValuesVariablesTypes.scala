package lectures.part1basics

object ValuesVariablesTypes extends App {

  // values (pretty much constants)

  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE (can't assign any new value to x)

  val y = 16

  println(y)

  // COMPILER can infer types

  val aString: String = "This is a string"; val anotherString: String = "The semicolon separation is discouraged"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = x // you can assign different values to value
  val aShort: Short = 4613   // expects representation of two bits - number cant be too big
  val aLong: Long = 5127892173892173L //Note L at the end; integer type but with double the representation
  val aFloat: Float = 2.0f  // note 'f' letter at the end; decimal number (without f compiler will assume its a double)
  val aDouble: Double = 3.14


  // variables

  var aVariable: Int = 4

  aVariable = 5 // side effects - allows to see what programme is doing
}
