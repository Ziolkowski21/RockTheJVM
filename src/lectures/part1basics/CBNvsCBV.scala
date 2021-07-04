package lectures.part1basics
// call by name vs call by value
object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {  // the "=>" parameters tells compiler that parameter is gonna be called by name
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())  // System.nanoTime() outputs the system time in nanoseconds
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34) // results in stack overflow
  printFirst(34, infinite())  // by name delays evaluation until is used, therefore infinite is never used and evaluated


}
