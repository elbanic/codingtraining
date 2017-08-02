import scala.math.BigDecimal
import scala.io.StdIn._

object VerificationPassword {

  val pwdbook = Map(("user1" -> "abc$1"), ("user2" -> "abc$2"))

  def main(args: Array[String]): Unit = {

    var status = true
    var user = ""
    do {
      user = input("What is the username: ")
      try {
        pwdbook(user)
        status = false
      }
      catch {
        case e: Exception => println(s"There is no such $user username.")
      }
    }while (status)

    val pwd = input("What is the password: ")
    if (pwdbook(user)==pwd) println("Welcome!")
    else println("That password is incorrect.")
  }
  def input(str: String): String = readLine(str)
}