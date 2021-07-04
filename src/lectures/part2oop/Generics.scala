package lectures.part2oop

object Generics extends App {

  class MyList[+A] {    // [A] denotes generic type - parametrized
      // use the type A in class definition
    def add[B >: A](element: B): MyList[B] = ???

    /*
    if A = Cat
    B = Dog = Animal
     */
  }

  class Map[keys, values] // it can have multiple type parameters

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String] // this generalisation makes the MyList reusable with different types

 // generic methods
  object MyList { // defining a MyList companion
   def empty[A]: MyList[A] = ??? // generic method empty parameterized with A
 }
  val emptyListOfIntegers = MyList.empty[Int] // generic trait

  // variance problem

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // if Cat extends Animal, does it mean a list of Cat extends also a list of Animal?
  // 3 answers:

  // 1. YES List[Cat] extends list[Animal] = COVARIANCE
  class CovariantList[+A] // + means covariant list
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]  // cannot replace Animal with cat and cat with animal
  // animalList.add(new Dog) ??? Hard question  --> we return list of animals

  // 2. NO list of cats and list of animals are two different things = INVARIANCE
  class InvariantList[A] // cannot substitute one to another
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // if to put Cat in 2nd it would throw error


  // 3. Hell, no! - Opposite Relationship - CONTRAVARIANCE
//  class ContravariantList[-A]
//  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  class Trainer[-A]
  val contravariantList: Trainer[Cat] = new Trainer[Animal] // trainer of animal is better than trainer of cat

  // bounded types
  class Cage[A <: Animal](animal: A) // class Cage only accepts type parameters A which are subtypes of Animal

  val cage = new Cage(new Dog)
  // val newCage = new Cage(new Car) // it's not gonna work as Car is not a subtype of Animal





}
