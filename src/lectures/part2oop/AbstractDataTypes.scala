package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstracts are used when you need to leave some field, methods or classes blank or unimplemented

  abstract class Animal {
    val creatureType: String = "wild" // value not defined - abstract
    def eat: Unit // Unimplemented therefore it's abstract
  }

  // animal = new Animal  //- cannot be instantiated because class is abstract

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Crunch crunch") // override keyword is not mandatory
  }

  // Traits - ultimate abstract data types in Scala
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded { // Crocodile inherits members from both Animal and Carnivore
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal:Animal): Unit = println(s"I am a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // both abstract classes and traits can have both abstract and non abstract members
  // traits do not have constructor parameters
  // you can extend only one class but mix multiple traits
  // traits = behaviour, abstract class = "thing"


}
