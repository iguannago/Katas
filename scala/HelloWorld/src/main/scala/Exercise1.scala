object Exercise1 {

  def subtract = (a: Int, b: Int) => a - b

  //different ways of define the add function
  def add = (a: Int, b: Int) => a + b

  def add2(a: Int, b: Int): Int = a + b

  def calculator(a: Int, b: Int, op: (Int, Int) => Int) = op(a, b)

  val isCarAffordable: Int => Boolean = (price: Int) => {
    if (price >= 10000) true
    else false
  }

  def main(args: Array[String]): Unit = {
    println("isCarAffordable: " + isCarAffordable(5000));
    val myList = List(1, 2, 3)
    println("add:")
    myList.foreach(e => println(add(e, 2)))

    println("subtract:")
    myList.foreach(e => println(subtract(e, 2)))

    println("calculator:")
    println(calculator(2, 3, (a, b) => a + b))
    println(calculator(2, 3, (a, b) => a - b))

    println("list of different things:")
    val anotherList = List(1, true, "David")
    anotherList.foreach(e => println(e))

  }
}
