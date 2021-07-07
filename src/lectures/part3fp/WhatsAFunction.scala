package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: we come from oop world

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) // doubler acts like a function (even though it is a value)

  // scala supports these function types out of the box
  // function types = Function1[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] == (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

}


trait MyFunction[A,B] {
  def apply(element: A): B
}
