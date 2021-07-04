package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck?!" // notice the space between ! and :
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar) - works only with methods which have only one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom) // method hangOutWith acts as operator between mary and tom which yields a string
  println(mary.+(tom))

  // + operators technically are method
  println(1 + 2)
  println(1.+(2) )

  // prefix notation
  val x = -1  // that "-" is an unary operator
  val y = 1.unary_-
  println(x == y)   // -1 is equivalent to 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // functions that not receive any parameters have the property that they can be used in a postfix notation

  println(mary.isAlive)
  println(mary isAlive)

  // apply

  println(mary.apply())
  println(mary()) // equivalent

}
