
object MadLibs {
  def main(args: Array[String]): Unit = {

    val noun = input("Enter a noun: ")
    val verb = input("Enter a verb: ")
    val adj = input("Enter an adjective: ")
    val adv = input("Enter an adverb: ")

    print(noun, verb, adj, adv)
  }

  def input(str: String): String = readLine(str)
  def print(n: String, v: String, adj: String, adv: String): Unit = {
    println("Do you " + v + " your " + adj + " " + n + " " + adv + "? That's hilarious!")
  }
}