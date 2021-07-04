package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (doesn't know a concept of "static")
  // it has an object (even better) - "static-like")

  object Person {
    val N_EYES = 2 // object can have val vars and methods

    def canFly: Boolean = false // main difference is that object cannot take parameters

    // factory method - sole purpose it to build Persons given some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // you can define class and object with the same name
    // this is to separate instance level functionality from "static"/"class" level functionality
  }
  // class Person and object Person are COMPANIONS


  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala Object = SINGLETON INSTANCE i.e by defining object person you basically define its type + its only instance
    val mary = new Person("Mary") // instance of Person type
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person.apply(mary, john)
    val bobbie2 = Person(mary, john)

  }
  // Scala applications = scala object with important method
  // def main(args: Array[String]): Unit
}
