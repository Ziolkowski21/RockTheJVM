package exercises.part2oop

abstract class MyListGenerics[+A] {

  /*
  methods:
      head = returns an int which is first element of the list
      tail = remainder of the list
      isEmpty = is this list empty (boolean)
      add(int) => new list with this element added
      toString => a string representation of the list
   */

  def head: A
  def tail: MyListGenerics[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenerics[B]

  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "] "

}


object EmptyGenerics extends MyListGenerics[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenerics[B] = new ConsGenerics(element, EmptyGenerics)

  def printElements: String = ""
}

class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {  // MyListGeneric is covariant so this need as well
  def head: A = h
  def tail: MyListGenerics[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenerics[B] = new ConsGenerics(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTestGenerics extends App {
  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics(1, new ConsGenerics(2, new ConsGenerics(3, EmptyGenerics)))
  val listOfStrings: MyListGenerics[String] = new ConsGenerics("Hello", new ConsGenerics("Scala", EmptyGenerics ))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}