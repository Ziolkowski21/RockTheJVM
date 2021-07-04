package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }


  // anonoymous class
  val funnyAnimal: Animal = new Animal  {
    override def eat: Unit = println("ahahahahahah")  // without the override it will try to instantiate abstract class
    // (impossible), with the override it instantiate real class
  }

  /*
  equivalent with:

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahahah")
  }
  val funnyAnimal: Animal = new Animal
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can i help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be on service?")
  }



}
