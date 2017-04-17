
object SimpleMath {
  def main(args: Array[String]): Unit = {

    val num1: String = input("What is the first number? ")
    val num2: String = input("What is the second number? ")

    printCalc(num1.toInt, num2.toInt)
  }

  def input(str: String): String = readLine(str)
  def printCalc(n1: Int, n2: Int): Unit = {

    println(s"${n1.toString} + ${n2.toString} = ${n1+n2}\n" +
      s"${n1.toString} - ${n2.toString} = ${n1-n2}\n" +
      s"${n1.toString} * ${n2.toString} = ${n1*n2}\n" +
      s"${n1.toString} / ${n2.toString} = ${n1/n2}\n")
  }
}