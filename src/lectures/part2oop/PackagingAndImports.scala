package lectures.part2oop

import playground.{Cindarella, PrinceCharming => Prince} // use => to rename a member (useful when several are called
                                                         // the same

object PackagingAndImports extends App {

  val writer = new Person("Maciek", 15) // can use Person class as is
  // i.e. package members are accessible by their simple name

  // to use class or trait from different package you need to IMPORT or specify package name during instantiation

  val princess = new Cindarella // or without import: val princess = new playground.Cindarella (fully qualified name)
  val prince = new Prince
  // package object
  sayHello
  println(SPEED_OF_LIGHT)



}
