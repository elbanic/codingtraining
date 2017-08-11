
import scala.io._

object WordCount {
  def main(args: Array[String]): Unit = {

    def lengthCheck(v: String): Boolean = if (v.length > 0) true else false
    var str = ""
    do {
      str = input()
    }
    while (!lengthCheck(str))
    println(output(str))
  }

  def input(): String = readLine("Please input text that you want to count of character : ")
  def output(str: String): String = {
    s"\'$str\' has ${counter(str)} characters"
  }

  def counter(str: String): Int = str.size
}