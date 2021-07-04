package lectures.part2oop

object Exceptions extends App {

	val x: String = null	// e.g. comes from other bit of code
//	println(x.length)
	// this ^^ will crash will a NullPointerException

	// 1. throwing exceptions
// 	val aWeirdValue= throw new NullPointerException	// new because exceptions are instances of classes

		// throwable classes extends the Throwable class.
		// Exception and Error are the major Throwable subtypes

	// 2. catching exceptions
	def getInt(withExceptions: Boolean): Int =
		if (withExceptions) throw new RuntimeException("No int for you")
		else 42

	val potentialFail = try {
		// code that might fail (throw)
		getInt(true)
	} catch {
		case e: RuntimeException => println("caught a Runtime exception")
	} finally {
		// code that will get executed NO MATTER WHAT
		// OPTIONAL
		// does not influence the return type of this expression
		// use finally only for side effects
		println("finally")
	}
	println(potentialFail)

	// 3. how to define your own exceptions
	class MyException extends Exception
	val exception = new MyException

	throw exception
}
