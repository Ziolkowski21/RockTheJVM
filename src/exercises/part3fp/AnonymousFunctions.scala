package exercises.part3fp

object AnonymousFunctions extends App{
  /*
  1. MyList: Replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function (the curried one)
   */

//  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
//    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
//      override def apply(y: Int): Int = x +y
//    }
//  }
//  val adder3 = superAdder(3)
//  println(adder3(4)) // x = 3, y = 4
//  println(superAdder(3)(4)) // curried function

  val superAdd = (x: Int) => (y: Int) =>  x + y
  println(superAdd(3)(4))

}
