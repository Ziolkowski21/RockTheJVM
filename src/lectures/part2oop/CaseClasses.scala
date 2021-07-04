package lectures.part2oop

object CaseClasses extends App {

	case class Person(name: String, age: Int)

	// 1. class parameters are fields
	val jim = new Person("Jim", 34)
	println(jim.name)

	// 2. sensible toString
	// println(instanceOfObject) = println(instanceOfObject.toString)	// syntactic sugar
	println(jim.toString)
	println(jim)

	// 3. equals and hashCode implemented OOTB (out of the box)
	val jim2 = new Person("Jim", 34)
	println(jim == jim2)	// returns true // if it would be just a class it would return false (it'd compare instance names)

	// 4. CCs (case classes) have handy copy method
	val jim3 = jim.copy() // same age and name
	val jim4 = jim.copy(age = 45) // same name, new age

	// 5. CCs have companion objects
	val thePerson = Person // Person is the companion object of this case class
	val mary = Person("Mary", 23) // no need to use "new" while instantiating

	// 6. CCs are serializable	// you can send instances of CCs through the network and in between JVMs
	// akka

	// 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

	case object UnitedKingdom {
		def name: String = "The UK of GB and NI"
	}

}
