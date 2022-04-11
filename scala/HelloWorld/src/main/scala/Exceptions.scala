import java.io.FileNotFoundException
import scala.io.Source._

object Exceptions extends App {

  try {
    for (line <- fromFile("nonExistentFile.txt").getLines()) {
      println(line)
    }
  }
  catch {
    case e: FileNotFoundException => println("File not found error: " + e)
    case _: Exception => println("There were some errors: " + _)
  }

}
