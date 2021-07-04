package exercises.part2oop

object OOBasics extends App {

  /*
  1. implement a novel and a writer class

  Writer - first name, surname, year of birth
    - method full name (concatenation of first and last name)

  Novel - name, year of release, author (instance of type writer)
    - methods: authorAge at the year of release
               isWrittenBy(author)
               copy (new year of release) = new instance of Novel

  2. Counter class
    - receive an int value
    - method current count
    - method to increment and decrement counter by one -> new counter
    - overload inc/dec to receive an amount
   */

  val writer = new Writer("Albert", "Camus", 1829)
  val novel = new Novel("Plague", 1891, writer)

  println(writer.fullName())
  println(novel.authorAge())
  println(novel.isWrittenBy(writer))
  val cp = novel.copy(2012)
  println(cp.authorAge())

  ///

  val counter = new Counter(0)
  counter.inc.print
  counter.dec.print
  counter.inc(5).print


}


class Writer(fName: String, lName: String, val year: Int)  {
  def fullName(): String = fName + " " + lName
}

class Novel(name: String, releaseYear: Int, author: Writer)  {
  def authorAge(): Int = releaseYear - author.year
  def isWrittenBy(author: Writer) = author == this.author // checks if book is written by said author, notice the
                                                          // way parameter is written
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability - whenever you need to modify the contents of the instance, you
    // actually need to return a new instance
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if ( n <= 0 ) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if ( n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}















