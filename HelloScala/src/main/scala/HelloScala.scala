
import scala.io._

object HelloScala {
  def main(args: Array[String]): Unit = {

    def lengthCheck(v: String): Boolean = if (v.length > 0) true else false
    var name = ""
    do {
      name = input()
    }
    while (!lengthCheck(name))
    println(output(name))
  }

  def input(): String = readLine("What's your name? ")
  def output(name: String): String = "Hello, " + name + ", nice to meet you!"
}