package playground

import java.util.NoSuchElementException
import scala.annotation.tailrec

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
  def addString: String
  override def toString: String = "[" + toString + "]"

}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def addString: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def addString: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.addString
  }
}

object ScalaPlayground extends App {



}