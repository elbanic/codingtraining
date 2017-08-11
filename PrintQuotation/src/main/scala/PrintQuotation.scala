
object PrintQuotation {
  def main(args: Array[String]): Unit = {

    def lengthCheck(v: String): Boolean = if (v.length > 0) true else false
    var quote = ""
    do {
      quote = inputQoute()
    }
    while (!lengthCheck(quote))

    var name = ""
    do {
      name = inputName()
    }
    while (!lengthCheck(name))

    print(quote, name)
  }

  def inputQoute(): String = readLine("What is the quote? ")
  def inputName(): String = readLine("Who said it? ")

  def print(q: String, n: String): Unit = {
    println(n + " says, " + "\"" + q + ".\"")
  }
}