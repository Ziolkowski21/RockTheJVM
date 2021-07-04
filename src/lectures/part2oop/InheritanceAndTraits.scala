package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"

    def eat = println("Nom nom nom")

    private def drink = println("Slurp") // can't be called by subclasses

    protected def jump = println("hop") // can be used inside the subclass
  }

  class Cat extends Animal { // in this instance Cat is a subclass of Animal and Animal is superclass of Cat
    def crunch = {
      jump
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat


  // constructors
  class Person(name: String, age: Int) {

  }

  // if superclass has parameters they must be passed while extending a subclass:
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  // you can override public and protected methods in subclass (also vars and vals)
  class Dog extends Animal {
    override def jump = println("crunch crunch")

    override val creatureType = "domestic"
  }

  val dog = new Dog
  dog.jump
  println(dog.creatureType)

  // you can override directly in the constructor but also inside the class:

  // overriding in constructor

  //class Dog(override val creatureType: String) extends Animal {
  //  override def jump = println("crunch crunch")
  //  override val creatureType = "domesticated"
  //}
  //val dog = new Dog("K9")
  //println(dog.creatureType) // gonna print "K9"

  //// overriding inside the class

  //class Dog2(dogType: String) extends Animal {
  //  override val creatureType = dogType
  //}

  // type substitution (broad: polymorphism)
  //  val unknownAnimal: Animal = new Dog("K9") // although declared as Animal it is instance of Dog so will use Dog method instead
  //  println(unknownAnimal.creatureType)

  // overRIDING vs overLOADING
  // overriding - supplying different implementation in derived classes
  // overloading - supplying multiple methods with different signatures but with the same name in the same class

  // super - used when you want to reference a method or a field from parent class

  // preventing overrides
  // 1. use keyword "final" on member
  // 2.  use keyword "final" on class itself (this prevents the entire class from being extended)
  // 3. seal the class = can extends the class in THIS FILE, but prevents from extending in other files)
}