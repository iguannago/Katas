object PatternMatching {

  def matcher(someString: String) = {
    someString match {
      case "david" | "DAVID" => println("It's you, David")
      case _ => println("I don't know you")
    }
  }

  def main(args: Array[String]): Unit = {
    matcher("daddfdfd")
  }

}
