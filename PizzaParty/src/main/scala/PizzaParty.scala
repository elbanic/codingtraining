
object PizzaParty {

  class ValueLeft(div: Int, target: Int) {
    lazy val value = target/div
    lazy val left = target%div
  }

  def main(args: Array[String]): Unit = {

    var people: Int = 0
    var pizza: Int = 0
    var piece: Int = 0
    def numberCheck(n: Int): Boolean = if (n <= 0) false else true
    do {
      people = try { input("How many people? ").toInt }
            catch { case e: Exception => e.printStackTrace; 0}
      pizza = try { input("How many pizzas do you have? ").toInt }
            catch { case e: Exception => e.printStackTrace; 0}
      piece = try { input("How many pieces are in a pizza? ").toInt }
            catch { case e: Exception => e.printStackTrace; 0}
    }
    while (!numberCheck(people) && !numberCheck(pizza) && !numberCheck(piece))
    printResult(people, pizza, piece)
  }

  def printResult(peo: Int, piz: Int, pie: Int): Unit ={

    val vl = calcValueLeft(peo, piz*pie)
    println(s"\t$peo people with $piz pizzas")
    println(s"\tEach person gets ${vl.value} pieces of pizza")
    println(s"\tThere are ${vl.left} leftover pieces")
  }

  def input(str: String): String = readLine(str)
  def calcValueLeft(div: Int, target: Int): ValueLeft = new ValueLeft(div, target)
}