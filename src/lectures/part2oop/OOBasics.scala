package lectures.part2oop

// Object Oriented Basics

object OOBasics extends App {

  val person = new Person("Dave", 12) // passing the parameters
  println(person.age)
  println(person.x)
  person.greet("Adam")
  person.greet()

}

// stuff inside the brackets is called constructor
class Person(name: String, val age: Int)  {
  //body

  val x = 2 // any vals and vars are fields and can be called in object

  println(1 + 3)  // for every intantiation of a object runs the class, therefore this bit is gonna be printed first

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // - if method has no parameters the name implies this.name

  // multiple/overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe") // quite impractical, default parameters are more easily to use

}

// class parameters are NOT FIELDS
