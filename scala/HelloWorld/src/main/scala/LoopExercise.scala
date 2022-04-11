object LoopExercise {

  def forLoop(): Unit = {
    for (x <- 10 to 0 by -1) {
      println(x)
    }
  }

  def main(args: Array[String]): Unit = {
    forLoop()
  }


}
