object PartialFunctionDemo {
  //创建一个普通的函数
  val div1 = (x:Int) => 100/x
  //定义一个偏函数
  val div2 = new PartialFunction[Int,Int] {
    override def isDefinedAt(x: Int): Boolean = x != 0

    override def apply(x: Int): Int = 100/x
  }

  //使用case定义偏函数
  val div3 : PartialFunction[Int,Int] = {
    case d:Int if(d != 0) => 100/d
  }

  val res : PartialFunction[Int,String] = {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  //orElse 组合多个偏函数，
  val r1 : PartialFunction[Int,String] = {case 1 =>"one"}
  val r2 : PartialFunction[Int,String] = {case 2 =>"two"}
  val r3 : PartialFunction[Int,String] = {case _ =>"other"}
  val res2 = r1.orElse(r2).orElse(r3)  //相当于res这个函数

  //andThen 多个偏函数串起来，流水线
  val r4 : PartialFunction[Int,String] = {case cs if(cs == 1) => "one"}
  val r5 : PartialFunction[String,String] = {case cs if(cs.equals("one")) => "the number is 1"}
  val res3:(Int => String) = r4.andThen(r5)


  def main(args: Array[String]): Unit = {
//    println(div1(0))
//    println(div2.isDefinedAt(1))
//    div2(1)
//    println(div2.isDefinedAt(0))
//    div2(0)

//    println(div3.isDefinedAt(1))
//    div3(1)
//    println(div3.isDefinedAt(0))
//    div3(0)

//    println(res2.isDefinedAt(1))
//    println(res2.isDefinedAt(3))
//    println(res2(1))
//    println(res2(3))
    println(res3(1))



  }
}
