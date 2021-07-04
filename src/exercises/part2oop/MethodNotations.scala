package exercises.part2oop

import lectures.part2oop.MethodNotations.Person

import scala.language.postfixOps

object MethodNotations extends App {

  /*
  1. Overload the "+" operator which receives a string and will return a new person
    e.g. mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class with default 0 value
     Add a unary + operator that increments a value of the age and gives a new person with the age + 1
     +mary => mary with the age incremented

  3. Add a "learns" method in the Person class => Mary learns $something
     Add a learnsScala method, calls learns method with "Scala"
     Use it in postfix notation

  4. Overload the apply method to receive a number and return a string
     mary.apply(2) => "Mary watched Inception 2 times"
   */

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    // from lecture
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck?!" // notice the space between ! and :
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"

    // from exercises
    def +(nickname: String): Person = new Person(s"$name '$nickname'", favoriteMovie, age)
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def learns(thing: String): String = s"$name learns $thing"
//    def learnsScala: String = s"$name learns Scala"
    def learnsScala = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  val maryWithNickname = mary + "The Rockstar"
  println(maryWithNickname.name)
  println((mary + "The Rockstar").name)
  println((mary + "The Rockstar")())  // the additional bracket means the method apply on resulting object from this expression

  println((+mary).age)

  println(mary.learns("Java"))
  println(mary learnsScala)

  println(mary(4))

}
