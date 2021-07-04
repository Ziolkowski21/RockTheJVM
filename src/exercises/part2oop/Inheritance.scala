package exercises.part2oop

abstract class MyList {

  /*
  methods:
      head = returns an int which is first element of the list
      tail = remainder of the list
      isEmpty = is this list empty (boolean)
      add(int) => new list with this element added
      toString => a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList

  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "] "  // override used as toString is default java command
  // immutable class as we're not modifying this class but rather create new instances

}

// we want to extend that class by two subclasses: empty and non empty lists

object Empty extends MyList { // objects can extend classes,
  //  we made it an object because all empty lists are equal, there's no point in having Empty be a class.
  // i.e. there won't be any other different instance of Empty

  def head: Int = throw new NoSuchElementException // in empty list there's no head and tail hence there's nothing
  // if you call empty object with head method it will crash with this exception
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)  // adding element to an empty list, creates non empty
  // ??? - returns nothing, used when you want to implement it later

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList { // non empty list, head (h) - first element, tail (t) - last element
  // cons will compose a value (head) with some other list (tail) - linked list
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
  val otherList = new Cons(1, new Cons(5, new Cons(4, Empty)))
  println(otherList.tail.head) // prints head of the tail i.e. 5
  println(list.add(4).head)
  println(Empty.isEmpty)

  // polymorphic call
  println(otherList.toString) // toString calls MyList method which calls otherList class type i.e. Cons method printElements
}