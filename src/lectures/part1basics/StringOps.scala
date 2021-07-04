package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(4))  // strings have methods, charAt - character at position 2 (starting from 0)
  println(str.substring(7, 11)) // from 7th symbol inclusive to 11th exclusive
  println(str.split(" ").toList) // separates the words separated by spaces into a list
  println(str.startsWith("Hello")) // tests if the string starts with Hello (true/false)
  println(str.replace(" ", "-")) // replaces spaces with dash
  println(str.toLowerCase())  // converts all upper cases into lower
  println(str.length())  // outputs the length of the string

  val aNumberString = "45"
  val aNumber = aNumberString.toInt // converts string into an integer
  println('a' +: aNumberString :+ 'z') // +: prepends i.e. concatenate "a" before aNumberString and :+ appends
  println(str.reverse)  // reverses the order of string
  println(str.take(2))  // will give first two characters out of the string

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age+1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute" //$speed%2.2f 2 characters minimum and 2 decimals precision
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")  // new line is gonna escape




}
