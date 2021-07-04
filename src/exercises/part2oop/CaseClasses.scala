package exercises.part2oop

import java.util.NoSuchElementException

/*
	Use case classes and case objects whenever you see fit
 */

abstract class MyCaseList[+A] {
	def headCase: A
	def tailCase: MyCaseList[A]
	def isEmptyCase: Boolean
	def addCase[B >: A](element: B): MyCaseList[B]
	def printElementsCase: String
	def toStringCase: String = "[" + printElementsCase + "]"

	def map[B](transformer: MyTransformerCase[A,B]): MyCaseList[B]
	def flatMap[B](transformer: MyTransformerCase[A,MyCaseList[B]]): MyCaseList[B]
	def filter(predicate: MyPredicateCase[A]): MyCaseList[A]

	// concatanation
	def ++[B >: A](list: MyCaseList[B]): MyCaseList[B]
}


case object EmptyCase extends MyCaseList[Nothing] {
	def headCase: Nothing = throw new NoSuchElementException
	def tailCase: MyCaseList[Nothing] = throw new NoSuchElementException
	def isEmptyCase: Boolean = true
	def addCase[B >: Nothing](element: B): MyCaseList[B] = new ConsCase(element, EmptyCase)
	def printElementsCase: String = ""

	def map[B](transformer: MyTransformerCase[Nothing,B]): MyCaseList[B] = EmptyCase
	def flatMap[B](transformer: MyTransformerCase[Nothing, MyCaseList[B]]): MyCaseList[B] = EmptyCase
	def filter(predicate: MyPredicateCase[Nothing]): MyCaseList[Nothing] = EmptyCase

	def ++[B >: Nothing](list: MyCaseList[B]): MyCaseList[B] = list
}

case class ConsCase[+A](h: A, t: MyCaseList[A]) extends MyCaseList[A] {
	def headCase: A = h
	def tailCase: MyCaseList[A] = t
	def isEmptyCase: Boolean = false
	def addCase[B >: A](element: B): MyCaseList[B] = new ConsCase(element, this)
	def printElementsCase: String =
		if (t.isEmptyCase) "" + h
		else h + " " + t.printElementsCase


	def filter(predicate: MyPredicateCase[A]): MyCaseList[A] =
		if (predicate.test(h)) new ConsCase(h,t.filter(predicate))
		else t.filter(predicate)


	def map[B](transformer: MyTransformerCase[A,B]): MyCaseList[B] = // if it's non empty so is result
		new ConsCase(transformer.transform(h), t.map(transformer))

	def ++[B >: A](list: MyCaseList[B]): MyCaseList[B] = new ConsCase(h, t ++ list)


	def flatMap[B](transformer: MyTransformerCase[A,MyCaseList[B]]): MyCaseList[B] =
		transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicateCase[-T] {
	def test(elem: T): Boolean
}

trait MyTransformerCase[-A, B] {
	def transform(elem: A): B
}



object ListTestCase extends App {
	val listOfIntegers: MyCaseList[Int] = new ConsCase(1, new ConsCase(2, new ConsCase(3, EmptyCase)))
	val cloneListOfIntegers: MyCaseList[Int] = new ConsCase(1, new ConsCase(2, new ConsCase(3, EmptyCase)))
	val anotherListOfIntegers: MyCaseList[Int] = new ConsCase(4, new ConsCase(5, EmptyCase))
	val listOfStrings: MyCaseList[String] = new ConsCase("Hello", new ConsCase("Scala", EmptyCase ))

	println(listOfIntegers.toStringCase)
	println(listOfStrings.toStringCase)

	println(listOfIntegers.map(new MyTransformerCase[Int, Int] {  // anonymous class
		override def transform(elem: Int): Int = elem * 2
	}).toStringCase)

	println(listOfIntegers.filter(new MyPredicateCase[Int] {
		override def test(elem: Int): Boolean = elem % 2 == 0
	}).toStringCase)

	println((listOfIntegers ++ anotherListOfIntegers).toStringCase)
	println(listOfIntegers.flatMap(new MyTransformerCase[Int, MyCaseList[Int]] {
		override def transform(elem: Int): MyCaseList[Int] = new ConsCase(elem, new ConsCase(elem + 1, EmptyCase))
	}).toStringCase)

	println(listOfIntegers == cloneListOfIntegers)	// returns true due to being case
}




