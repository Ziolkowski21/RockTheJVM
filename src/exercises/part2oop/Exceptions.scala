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
//	def infinite: Int = 1 + infinite
//	val noLimit = infinite
	

	class OverflowException extends Exception
	class UnderflowException extends Exception
	class MathCalculationException extends Exception

	class PocketCalculator {

		def add(x: Int, y: Int): Int = {
			// if ((x + y) >= Int.MaxValue) throw new OverflowException
			// can't compare (x + y) with MaxValue (as for x+y > MaxValue is always false)
			// but if you overflow it, it suddenly becomes negative, hence:
			val result = x + y
			if (x > 0 && y > 0 && result < 0) throw new OverflowException
			else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
			else result
		}

		def subtract(x: Int, y: Int): Int = {
			val result = x - y
			if (x > 0 && y < 0 && result < 0) throw new OverflowException
			else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
			else result
		}

		def multiply(x: Int, y: Int): Int = {
			val result = x * y
			if (x > 0 && y > 0 && result < 0) throw new OverflowException
			else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
			else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
			else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
			else result
		}

		def divide(x: Int, y: Int): Int = {
			if (y == 0) throw new MathCalculationException
			else x / y
		}

	}
	val calc = new PocketCalculator
//	println(calc.subtract(-10,Int.MinValue))
	println(calc.divide(4,0))
}
