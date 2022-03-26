object OptionDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("a"->1,"b"->2)
//    println(map("a"))
//    println(map("c"))
    val a:Option[Int] = map.get("a")
    println(a)
    map.getOrElse("c",0)


  }
}
