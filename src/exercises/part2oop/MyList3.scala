package exercises.part2oop

import java.util.NoSuchElementException

/*
  EXERCISES

  1. Generic trait MyPredicate[-T] - with method to test whether a value of type T passes a condition
  2. Generic trait MyTransformer[-A, B] - method to convert a value of type A to type B, every subclass of MyTransformer
  will have different implementation of that method r
  3. functions implemented on MyList:
      - map(MyTransformer) => MyList
      - filter(MyPredicate) => MyList
      - flatMap(transformer from A to MyList[B] => MyList[B]

  i.e.
  1. test(T) => Boolean, if i have class EvenPredicate extends MyPredicate[Int], the test method will take int
  as parameter and will return if its even or not
  2. class StringToIntTransformer extends MyTransformer[String, Int]

  3. list [1, 2, 3].map(n * 2) = [2, 4, 6]
     [1, 2, 3, 4].filter(n % 2) = [2, 4]
     [1, 2, 3].flatMap(n => [n, n+1]) => [1, 2, 2, 3, 3, 4] for each n you will get list [n, n+1] that will be concatenated
     Hint: without contravariant code won't compile (hence, -T, -A)
 */


abstract class MyList3[+A] {
  def head3: A
  def tail3: MyList3[A]
  def isEmpty3: Boolean
  def add3[B >: A](element: B): MyList3[B]
  def printElements3: String
  def toString3: String = "[" + printElements3 + "]"

  def map[B](transformer: MyTransformer[A,B]): MyList3[B]
  def flatMap[B](transformer: MyTransformer[A,MyList3[B]]): MyList3[B]
  def filter(predicate: MyPredicate[A]): MyList3[A]

  // concatanation
  def ++[B >: A](list: MyList3[B]): MyList3[B]
}


object Empty3 extends MyList3[Nothing] {
  def head3: Nothing = throw new NoSuchElementException
  def tail3: MyList3[Nothing] = throw new NoSuchElementException
  def isEmpty3: Boolean = true
  def add3[B >: Nothing](element: B): MyList3[B] = new Cons3(element, Empty3)
  def printElements3: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): MyList3[B] = Empty3
  def flatMap[B](transformer: MyTransformer[Nothing, MyList3[B]]): MyList3[B] = Empty3
  def filter(predicate: MyPredicate[Nothing]): MyList3[Nothing] = Empty3

  def ++[B >: Nothing](list: MyList3[B]): MyList3[B] = list
}

class Cons3[+A](h: A, t: MyList3[A]) extends MyList3[A] {
  def head3: A = h
  def tail3: MyList3[A] = t
  def isEmpty3: Boolean = false
  def add3[B >: A](element: B): MyList3[B] = new Cons3(element, this)
  def printElements3: String =
    if (t.isEmpty3) "" + h
    else h + " " + t.printElements3

  /*
  [1, 2, 3].filter(n % 2 == 0) --> is 1 % 2 == 0? no, so:
  t.filter(n % 2 == 0) = [2, 3].filter(n % 2 == 0] --> is 2 % 2 == 0? yes, so:
  new Cons3(2, [3].filter(n % 2 == 0)) --> is 3 % 2 == 0? no, so:
  new Cons3(2, Empty.filter(n % 2 == 0)) --> new Cons3(2, Empty) = [2]
   */
  def filter(predicate: MyPredicate[A]): MyList3[A] =
    if (predicate.test(h)) new Cons3(h,t.filter(predicate))
    else t.filter(predicate)
    // if head passes the predicate it will be included in the result, and result gonna be a Cons with head and tail
    // will be filtered with predicate otherwise head does not pass the predicate and will not be included in the result

  /*
    [1, 2, 3].map(n * 2) (sudo syntax)
      = new Cons(transformer.transform(1), [2, 3].map(transformer)) --> transformer = MyTransformer[Int, 2 * Int]
      transformer.transform(1) = 1 * 2,
      t.map(transformer)  -> new Cons(transformer.transform(2), new_t.map(transformer))

     i.e.
     [1, 2, 3].map(n * 2)
      = new Cons(1 * 2, [2, 3].map(n*2))
      = new Cons(1 * 2, new Cons(2 * 2, [3].map(n*2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  def map[B](transformer: MyTransformer[A,B]): MyList3[B] = // if it's non empty so is result
    new Cons3(transformer.transform(h), t.map(transformer))
//    def flatMap[B](transformer: MyTransformer[A, MyList3[B]]): MyList3[B] =

  /*
  [1,2] ++ [3, 4 ,5]
    = new Cons(1, [2] ++ [3, 4 ,5])
    = new Cons(1, new Cons(2, Empty ++ [3, 4, 5])))
    = new Cons(1, new Cons(2, [3,4,5])))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))))))
   */
  def ++[B >: A](list: MyList3[B]): MyList3[B] = new Cons3(h, t ++ list)

  /*
  [1,2].flatMap(n => [n, n+1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: MyTransformer[A,MyList3[B]]): MyList3[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
  }

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}



object ListTest3 extends App {
  val listOfIntegers: MyList3[Int] = new Cons3(1, new Cons3(2, new Cons3(3, Empty3)))
  val anotherListOfIntegers: MyList3[Int] = new Cons3(4, new Cons3(5, Empty3))
  val listOfStrings: MyList3[String] = new Cons3("Hello", new Cons3("Scala", Empty3 ))

  println(listOfIntegers.toString3)
  println(listOfStrings.toString3)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {  // anonymous class
    override def transform(elem: Int): Int = elem * 2
  }).toString3)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString3)

  println((listOfIntegers ++ anotherListOfIntegers).toString3)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList3[Int]] {
    override def transform(elem: Int): MyList3[Int] = new Cons3(elem, new Cons3(elem + 1, Empty3))
  }).toString3)

}




