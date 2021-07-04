package exercises.part2oop

object Exceptions extends App {

	/*
		1. Crash your programme with an OutOfMemoryError
		2. Crash with StackOverflowError
		3. make a Class PocketCalculator with
			- add(x,y)
			- subtract(x,y)
			- multiply(x,y)
			- divide(x,y)

			Throw
				- OverflowException if add(x,y) exceed Int.MAX_VALUE
				- UnderflowException if subtract(x,y) exceed Int.MIN_VALUE
				- MathCalculationException for division by 0
	 */

//	throw new OutOfMemoryError
//	val array = Array.ofDim(Int.MaxValue)	// make an array of dimension of:

//	throw new StackOverflowError("RIP")
	

	class OverflowException extends Exception
	class UnderflowException extends Exception
	class MathCalculationException extends Exception

	class PocketCalculator {

		def add(x: Int, y: Int): Int = {
			if ((x + y) >= Int.MaxValue) throw new OverflowException
			else x + y
		}

		def subtract(x: Int, y: Int): Int = {
			if ((x - y) <= Int.MinValue) throw new UnderflowException
			else x - y
		}

		def multiply(x: Int, y: Int): Int = {
			if ((x * y) >= Int.MaxValue) throw new OverflowException
			else x * y
		}

		def divide(x: Int, y: Int): Int = {
			if (y == 0) throw new MathCalculationException
			else x / y
		}

	}
	val calc = new PocketCalculator
	println(calc.subtract(-10,Int.MaxValue))

}
