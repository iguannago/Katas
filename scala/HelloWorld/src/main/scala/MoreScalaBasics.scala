import scala.io.Source._
import scala.io.StdIn._

object MoreScalaBasics extends App {

  var name = readLine("Enter your name, please: ")
  println(name)

  val fileName = "src/main/scala/rainbow.txt"
  for (line <- fromFile(fileName).getLines()) {
    println(line)
  }

}
