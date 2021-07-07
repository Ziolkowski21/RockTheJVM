package exercises.part3fp

object WhatsAFunction extends App {

  /*
    1.  a function which takes two strings and concatanates them
    2.  transform MyPredicate and MyTransformer into function types
    3.  define a function which takes an argument and returns another function which takes an int and returns int
        - what's type of this function?
        - how to do it
   */

  val concatenator: (String, String) => String = new Function2[String,String,String] {
    override def apply(str1: String, str2: String): String = str1 + str2
  }
  println(concatenator("Hello", "Scala"))

  /* trait  MyPredicate[-T] { // T => Boolean
    def test(elem: T): Boolean
    }
     trait MyTransformer[-A, B] { // A => B
      def transform(elem: A): B
      }
   */

 // 3. it's a higher order function
  // Function1[Int, Function1[Int, Int]] - type
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x +y
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4)) // x = 3, y = 4
  println(superAdder(3)(4)) // curried function



}
