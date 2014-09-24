import crypto.week01.Decrypter

object Hi {
  def main(args: Array[String]) {
    val dec = new Decrypter
    println(dec.myxor("aa12", "bf"));
    println(dec.xor("aa12", "bf"));

  }

}

